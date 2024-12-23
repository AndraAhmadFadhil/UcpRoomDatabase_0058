package com.example.pampertemuan11.ui.viewmodel

import com.example.pampertemuan11.data.entity.Barang

data class BarUIState(
    val barangEvent: BarangEvent = BarangEvent(),
    val isEntrValid: FormErrorStateBar = FormErrorStateBar(),
    val snackbarMessage: String? = null
)

data class FormErrorStateBar(
    val id: Int? = null,
    val nama: String? = null,
    val deskripsi: String? = null,
    val harga: String? = null,
    val stok: String? = null,
    val namaSuplier: String? = null,
){
    fun isValid(): Boolean{
        return id == null &&
                nama == null &&
                deskripsi == null &&
                harga == null &&
                stok == null &&
                namaSuplier == null
    }
}

fun BarangEvent.toBarangEntity(): Barang = Barang(
    id = id,
    nama = nama,
    deskripsi = deskripsi,
    harga = harga,
    stok = stok,
    namaSupplier = namaSupplier,
)

data class BarangEvent(
    val id: Int = 0,
    val nama: String = "",
    val deskripsi: String = "",
    val harga: String = "",
    val stok: String = "",
    val namaSupplier: String = "",
)