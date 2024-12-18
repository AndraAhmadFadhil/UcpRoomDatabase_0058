package com.example.pampertemuan11.data.repository

import com.example.pampertemuan11.data.dao.BarangDao
import com.example.pampertemuan11.data.entity.Barang
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

    override fun getBrg(idBrg:String): Flow<Barang> {
        return barangDao.getBarang(idBrg)
    }

    override suspend fun deleteBrg(barang: Barang) {
        barangDao.deleteBarang(barang)
    }

    override suspend fun updateBrg(barang: Barang) {
        barangDao.updateBarang(barang)
    }
}