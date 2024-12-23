package com.example.ucp_2pam.Data.Repository.Suplier

import com.example.ucp_2pam.Entity.Suplier
import com.example.ucp_2pam.data.dao.SuplierDao
import kotlinx.coroutines.flow.Flow


class LocalRepositorySpl(
    private val suplierDao: SuplierDao
) : RepositorySpl {
    override suspend fun insertSuplier(suplier: Suplier) {
        suplierDao.insertSuplier(suplier)
    }
    override fun getAllSuplier(): Flow<List<Suplier>> =
        suplierDao.getAllSuplier()

    override fun getSuplier(id: Int): Flow<Suplier> =
        suplierDao.getSuplier(id)
}