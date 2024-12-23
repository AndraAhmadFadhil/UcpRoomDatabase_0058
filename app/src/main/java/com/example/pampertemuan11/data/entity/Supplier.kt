package com.example.pampertemuan11.data.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "supplier",
    indices = [Index(value = ["nama"], unique = true)]
)
data class Supplier (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val kontak: String,
    val alamat: String
)