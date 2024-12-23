package com.example.pampertemuan11.repository

import com.example.pampertemuan11.data.entity.Barang
import com.example.pampertemuan11.data.entity.Supplier
import kotlinx.coroutines.flow.Flow

interface RepositoryBrg {
    suspend fun insertBrg(barang: Barang)

    //getAllBrg
    fun getAllBrg(): Flow<List<Barang>>

    //getBrg
    fun getNamaBrg(idBrg: String): Flow<Barang>

    fun getNamaSpl(idBrg: String): Flow<Supplier>

    //deleteBrg
    suspend fun deleteBrg(barang: Barang)

    //updateBrg
    suspend fun updateBrg(barang: Barang)
}