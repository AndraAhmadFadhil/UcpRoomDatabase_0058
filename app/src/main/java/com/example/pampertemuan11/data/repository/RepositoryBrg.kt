package com.example.pampertemuan11.data.repository

import com.example.pampertemuan11.data.entity.Barang
import kotlinx.coroutines.flow.Flow

interface RepositoryBrg {
    suspend fun insertBrg(barang: Barang)

    //getAllBrg
    fun getAllBrg(): Flow<List<Barang>>

    //getBrg
    fun getBrg(idBrg: String): Flow<Barang>

    //deleteBrg
    suspend fun deleteBrg(barang: Barang)

    //updateBrg
    suspend fun updateBrg(barang: Barang)
}