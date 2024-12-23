package com.example.ucp_2pam.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ucp_2pam.Entity.Barang
import com.example.ucp_2pam.Entity.Suplier
import com.example.ucp_2pam.data.dao.BarangDao
import com.example.ucp_2pam.data.dao.SuplierDao


@Database(entities = [Barang::class, Suplier::class], version = 1, exportSchema = false)
abstract class TokoDatabase : RoomDatabase(){
    abstract fun barangDao(): BarangDao
    abstract fun suplierDao(): SuplierDao

    companion object {
        @Volatile
        private var INSTANCE: TokoDatabase? = null

        fun getDatabase(context: Context): TokoDatabase {
            return (INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    TokoDatabase::class.java,
                    "TokoDatabase"
                )
                    .build()
                    .also { INSTANCE = it }
            })
        }
    }
}