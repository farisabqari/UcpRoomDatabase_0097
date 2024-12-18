package com.example.ucp_2pam.Data.Repository

import com.example.ucp_2pam.Data.Dao.BarangDao
import com.example.ucp_2pam.Data.Entity.Barang

class LocalRepositoryBrg (private val barangDao: BarangDao) {

        // Fungsi untuk menambahkan Barang (Create)
        suspend fun insertBarang(barang: Barang) {
            barangDao.insertBarang(barang)
        }

        // Fungsi untuk mengambil semua Barang (Read)
        suspend fun getAllBarang(): List<Barang> {
            return barangDao.getAllBarang()
        }

        // Fungsi untuk memperbarui data Barang (Update)
        suspend fun updateBarang(barang: Barang) {
            barangDao.updateBarang(barang)
        }

        // Fungsi untuk menghapus Barang (Delete)
        suspend fun deleteBarang(barang: Barang) {
            barangDao.deleteBarang(barang)
        }

        // Fungsi untuk mendapatkan detail Barang berdasarkan ID
        suspend fun getDetailBarang(id: Int): Barang {
            return barangDao.getDetailBarang(id)
        }
    }

}