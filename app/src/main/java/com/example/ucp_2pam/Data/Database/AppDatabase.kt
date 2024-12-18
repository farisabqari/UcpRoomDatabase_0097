package com.example.ucp_2pam.Data.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ucp_2pam.Data.Dao.BarangDao
import com.example.ucp_2pam.Data.Dao.SuplierDao
import com.example.ucp_2pam.Data.Entity.Barang
import com.example.ucp_2pam.Data.Entity.Suplier

@Database(entities = [Barang::class, Suplier::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun suplierDao(): SuplierDao
    abstract fun barangDao(): BarangDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "inventory_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
