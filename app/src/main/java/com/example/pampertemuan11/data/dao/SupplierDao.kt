package com.example.pampertemuan11.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pampertemuan11.data.entity.Supplier
import kotlinx.coroutines.flow.Flow


@Dao
interface SupplierDao {
    @Insert
    suspend fun insertSupplier(
        supplier: Supplier
    )

    @Query("SELECT * FROM supplier ORDER BY namaSupplier ASC")
    fun getAllSupplier(): Flow<List<Supplier>>

    @Query("SELECT * FROM supplier WHERE idSupplier = idSupplier")
    fun getSupplier (id: String): Flow<Supplier>
}