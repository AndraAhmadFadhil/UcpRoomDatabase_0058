package com.example.pampertemuan11.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "barang",
    foreignKeys = [
        ForeignKey(
            entity = Supplier::class,
            parentColumns = ["nama"],
            childColumns = ["namaSupplier"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Barang (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val namaBrg: String,
    val deskripsiBrg: String,
    val hargaBrg: String,
    val stokBrg: String,
    val namaSupplier: String
)