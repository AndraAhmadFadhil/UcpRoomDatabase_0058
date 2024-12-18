package com.example.pampertemuan11.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "barang")
data class Barang (
    @PrimaryKey
    val idBrg: String,
    val namaBrg: String,
    val deskripsiBrg: String,
    val hargaBrg: String,
    val stokBrg: String,
    val namaSupplier: String
)