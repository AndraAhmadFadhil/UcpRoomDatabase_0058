package com.example.pampertemuan11.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.pampertemuan11.data.entity.Barang
import com.example.pampertemuan11.data.entity.Supplier
import kotlinx.coroutines.flow.Flow


@Dao
interface BarangDao {
    @Insert
    suspend fun insertBarang(
        barang: Barang
    )

    @Query("SELECT * FROM barang ORDER BY nama ASC")
    fun getAllBarang(): Flow<List<Barang>>

    @Query("SELECT * FROM barang WHERE nama = :nama")
    fun getNamaBarang (nama: String): Flow<Barang>

    @Query("SELECT * FROM supplier WHERE nama = :nama")
    fun getNamaSuplier(nama: String): Flow<Supplier>

    @Delete
    suspend fun deleteBarang(barang: Barang)

    @Update
    suspend fun updateBarang(barang: Barang)
}