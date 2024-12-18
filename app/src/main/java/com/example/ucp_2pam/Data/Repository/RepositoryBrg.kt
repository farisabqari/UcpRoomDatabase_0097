package com.example.ucp_2pam.Data.Repository

import com.example.ucp_2pam.Data.Dao.BarangDao
import com.example.ucp_2pam.Data.Entity.Barang

interface RepositoryBrg {
    class BarangRepository(private val dao: BarangDao) {
        suspend fun insertBarang(barang: Barang) = dao.insertBarang(barang)
        suspend fun getAllBarang() = dao.getAllBarang()
        suspend fun updateBarang(barang: Barang) = dao.updateBarang(barang)
        suspend fun deleteBarang(barang: Barang) = dao.deleteBarang(barang)
        suspend fun getBarangById(id: Int) = dao.getBarangById(id)
    }

}