package com.example.pampertemuan11.ui.viewmodel

import com.example.pampertemuan11.data.entity.Supplier

data class FormErrorStateSup(
    val id: Int? = null,
    val nama: String? = null,
    val kontak: String? = null,
    val alamat: String? = null
){
    fun isValid(): Boolean{
        return id == null &&
                nama == null &&
                kontak == null &&
                alamat == null
    }
}

fun SuplierEvent.toSuplierEntity(): Supplier = Supplier(
    id = id,
    nama = nama,
    kontak = kontak,
    alamat = alamat
)

data class SuplierEvent(
    val id: Int = 0,
    val nama: String = "",
    val kontak: String = "",
    val alamat: String = ""
)