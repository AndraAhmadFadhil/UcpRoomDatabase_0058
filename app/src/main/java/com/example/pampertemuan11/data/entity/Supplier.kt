package com.example.pampertemuan11.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "supplier")
data class Supplier (
    @PrimaryKey
    val idSupplier: String,
    val namaSupplier: String,
    val kontakSupplier: String,
    val alamatSupplier: String
)