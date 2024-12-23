package com.example.pampertemuan11.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pampertemuan11.data.entity.Barang
import com.example.pampertemuan11.repository.RepositoryBrg
import com.example.pampertemuan11.ui.navigation.DestinasiUpdate
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class UpdateBrgViewModel(
    savedStateHandle: SavedStateHandle,
    private val RepositoryBarang: RepositoryBrg
): ViewModel(){
    var updateUIStateBrg by mutableStateOf(BarUIState())
        private set

    private val _nama: String = checkNotNull(savedStateHandle[DestinasiUpdate.NAMA])

    init {
        viewModelScope.launch {
            updateUIStateBrg = RepositoryBarang.getNamaBrg(_nama)
                .filterNotNull()
                .first()
                .toUIStateBrg()
        }
    }
    fun updateState(barangEvent: BarangEvent){
        updateUIStateBrg = updateUIStateBrg.copy(
            barangEvent = barangEvent
        )
    }

    fun validateFields(): Boolean{
        val event = updateUIStateBrg.barangEvent
        val errorState = FormErrorStateBar(
            nama = if (event.nama.isNotEmpty()) null else "Nama Tidak Boleh Kosong",
            deskripsi = if (event.deskripsi.isNotEmpty()) null else "Deskripsi Tidak Boleh Kosong",
            harga = if (event.harga.isNotEmpty()) null else "Harga Tidak Boleh Kosong",
            stok = if (event.stok.isNotEmpty()) null else "Stok Tidak Boleh Kosong",
            namaSuplier = if (event.namaSupplier.isNotEmpty()) null else "Nama Suplier Tidak Boleh Kosong",

            )
        updateUIStateBrg = updateUIStateBrg.copy(isEntrValid = errorState)
        return errorState.isValid()
    }

    fun updateData(){
        val currentEvent = updateUIStateBrg.barangEvent

        if (validateFields()){
            viewModelScope.launch {
                try {
                    RepositoryBarang.updateBrg(currentEvent.toBarangEntity())
                    updateUIStateBrg = updateUIStateBrg.copy(
                        snackbarMessage = "Data Berhasil Diupdate",
                        barangEvent = BarangEvent(id = Int.MIN_VALUE),
                        isEntrValid = FormErrorStateBar()
                    )
                    println("snackbarMessage diatur: ${updateUIStateBrg.snackbarMessage}")

                } catch (e: Exception){
                    updateUIStateBrg = updateUIStateBrg.copy(
                        snackbarMessage = "Data gagal Diupdate"
                    )
                }
            }
        } else{
            updateUIStateBrg = updateUIStateBrg.copy(
                snackbarMessage = "Data gagal diupdate"
            )
        }
    }

    fun resetSnackBarMessage(){
        updateUIStateBrg = updateUIStateBrg.copy(snackbarMessage = null)
    }
}

fun Barang.toUIStateBrg(): BarUIState = BarUIState(
    barangEvent = this.toDetailUiEvent()
)