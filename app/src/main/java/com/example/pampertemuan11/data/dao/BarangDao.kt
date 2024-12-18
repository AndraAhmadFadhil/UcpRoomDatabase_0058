package com.example.pampertemuan11.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.pampertemuan11.data.entity.Barang
import kotlinx.coroutines.flow.Flow


@Dao
interface BarangDao {
    @Insert
    suspend fun insertBarang(
        barang: Barang
    )

    @Query("SELECT * FROM barang ORDER BY namaBrg ASC")
    fun getAllBarang(): Flow<List<Barang>>

    @Query("SELECT * FROM barang WHERE idBrg = idBrg")
    fun getBarang (id: String): Flow<Barang>

    @Delete
    suspend fun deleteBarang(barang: Barang)

    @Update
    suspend fun updateBarang(barang: Barang)
}