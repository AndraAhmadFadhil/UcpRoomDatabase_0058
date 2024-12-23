package com.example.pampertemuan11.repository

import com.example.pampertemuan11.data.dao.SupplierDao
import com.example.pampertemuan11.data.entity.Supplier
import kotlinx.coroutines.flow.Flow

class LocalRepositorySpl(private val supplierDao: SupplierDao) : RepositorySpl {
    override suspend fun insertSpl(supplier: Supplier) {
        supplierDao.insertSupplier(supplier)
    }

    override fun getAllSpl(): Flow<List<Supplier>> {
        return supplierDao.getAllSuplier()
    }
}