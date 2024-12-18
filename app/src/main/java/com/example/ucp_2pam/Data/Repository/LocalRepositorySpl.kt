package com.example.ucp_2pam.Data.Repository

import com.example.ucp_2pam.Data.Dao.SuplierDao
import com.example.ucp_2pam.Data.Entity.Suplier

class LocalRepositorySpl (private val suplierDao: SuplierDao){


        // Fungsi untuk menambahkan Suplier (Create)
        suspend fun insertSuplier(suplier: Suplier) {
            suplierDao.insertSuplier(suplier)
        }

        // Fungsi untuk mengambil semua data Suplier (Read)
        suspend fun getAllSuplier(): List<Suplier> {
            return suplierDao.getAllSuplier()
        }
    }

}