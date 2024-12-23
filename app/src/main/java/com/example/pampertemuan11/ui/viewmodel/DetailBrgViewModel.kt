package com.example.pampertemuan11.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pampertemuan11.data.entity.Barang
import com.example.pampertemuan11.repository.RepositoryBrg
import com.example.pampertemuan11.ui.navigation.DestinasiDetail
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DetailBrgViewModel(
    savedStateHandle: SavedStateHandle,
    private val RepositoryBarang: RepositoryBrg
): ViewModel(){
    private val _nama: String = checkNotNull(savedStateHandle[DestinasiDetail.NAMA])

    val detailUiState: StateFlow<DetailUiState> = RepositoryBarang.getNamaBrg(_nama)
        .filterNotNull()
        .map {
            DetailUiState(
                detailUiEvent = it.toDetailUiEvent(),
                isLoading = false
            )
        }
        .onStart {
            emit(DetailUiState(isLoading = true))
            delay(600)
        }
        .catch {
            emit(
                DetailUiState(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message ?: "Terjadi Kesalahan"
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(2000),
            initialValue = DetailUiState(
                isLoading = true
            )
        )
    fun deleteBar(){
        detailUiState.value.detailUiEvent.toBarangEntity().let {
            viewModelScope.launch {
                RepositoryBarang.deleteBrg(it)
            }
        }
    }
}

data class DetailUiState(
    val detailUiEvent: BarangEvent = BarangEvent(id = Int.MIN_VALUE),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
){
    val isUiEventEmpty: Boolean
        get() = detailUiEvent == BarangEvent(id = Int.MIN_VALUE)

    val isUiEventNotEmpty: Boolean
        get() = detailUiEvent != BarangEvent(id = Int.MIN_VALUE)
}

fun Barang.toDetailUiEvent(): BarangEvent{
    return BarangEvent(
        id = id,
        nama = nama,
        deskripsi = deskripsi,
        harga = harga,
        stok = stok,
        namaSupplier = namaSupplier,
    )
}