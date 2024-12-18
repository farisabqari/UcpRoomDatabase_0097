package com.example.ucp_2pam.Data.Repository

import com.example.ucp_2pam.Data.Dao.SuplierDao
import com.example.ucp_2pam.Data.Entity.Suplier

interface RepositorySpl {
    class SuplierRepository(private val dao: SuplierDao) {
        suspend fun insertSuplier(suplier: Suplier) = dao.insertSuplier(suplier)
        suspend fun getAllSupliers() = dao.getAllSupliers()
    }

}