package com.example.pampertemuan11.repository

import com.example.pampertemuan11.data.dao.BarangDao
import com.example.pampertemuan11.data.entity.Barang
import com.example.pampertemuan11.data.entity.Supplier
import kotlinx.coroutines.flow.Flow

class LocalRepositoryBrg (
   private val barangDao: BarangDao
) : RepositoryBrg {
    override suspend fun insertBrg(barang: Barang) {
        barangDao.insertBarang(barang)
    }

    override fun getAllBrg(): Flow<List<Barang>> {
        return barangDao.getAllBarang()
    }

    override fun getNamaBrg(nama:String): Flow<Barang> {
        return barangDao.getNamaBarang(nama)
    }

    override suspend fun deleteBrg(barang: Barang) {
        barangDao.deleteBarang(barang)
    }

    override suspend fun updateBrg(barang: Barang) {
        barangDao.updateBarang(barang)
    }

    override fun getNamaSpl(nama: String): Flow<Supplier> {
        return barangDao.getNamaSuplier(nama)
    }
}