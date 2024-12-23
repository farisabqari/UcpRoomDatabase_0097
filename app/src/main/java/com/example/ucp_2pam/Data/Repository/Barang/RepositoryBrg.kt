package com.example.ucp_2pam.Data.Repository.Barang

import com.example.ucp_2pam.Entity.Barang
import kotlinx.coroutines.flow.Flow

interface RepositoryBrg {
    suspend fun insertBarang(barang: Barang)
    fun getAllBarang(): Flow<List<Barang>>
    fun getBarang(id: String): Flow<Barang>
    suspend fun deleteBarang(barang: Barang)
    suspend fun updateBarang(barang: Barang)
}