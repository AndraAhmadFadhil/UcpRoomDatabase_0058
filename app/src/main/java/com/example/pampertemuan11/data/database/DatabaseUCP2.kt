package com.example.pampertemuan11.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pampertemuan11.data.dao.BarangDao
import com.example.pampertemuan11.data.dao.SupplierDao
import com.example.pampertemuan11.data.entity.Barang
import com.example.pampertemuan11.data.entity.Supplier

//Mendefinisikan database dengan tabel mahasiswa
@Database(entities = [Barang::class, Supplier::class], version = 1, exportSchema = false)
abstract class DatabaseUCP2 : RoomDatabase() {

    //Mendefinisikan fungsi untuk mengakses data Mahasiswa
    abstract fun barangDao(): BarangDao
    abstract fun supplierDao(): SupplierDao

    companion object{
        private var Instance: DatabaseUCP2? = null

        fun getDatabase(context: Context): DatabaseUCP2{
            return(Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    DatabaseUCP2::class.java,
                    "DatabaseUcp"
                )
                    .build().also { Instance = it }
            })
        }
    }

}
