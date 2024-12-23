package com.example.pampertemuan11.ui.viewmodel

import com.example.pampertemuan11.data.entity.Supplier


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