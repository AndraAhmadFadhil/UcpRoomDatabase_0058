package com.example.pampertemuan11.repository

import com.example.pampertemuan11.data.entity.Supplier
import kotlinx.coroutines.flow.Flow

interface RepositorySpl {
    suspend fun insertSpl(Supplier: Supplier)

    fun getAllSpl(): Flow<List<Supplier>>
}