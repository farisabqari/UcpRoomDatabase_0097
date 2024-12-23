package com.example.ucp_2pam.Data.Repository.Suplier

import com.example.ucp_2pam.Entity.Suplier
import kotlinx.coroutines.flow.Flow

interface RepositorySpl {
    suspend fun insertSuplier(suplier: Suplier)
    fun getAllSuplier(): Flow<List<Suplier>>
    fun getSuplier(id: Int): Flow<Suplier>
}