package com.example.ucp_2pam.Data.dependenciesinjection

import android.content.Context
import com.example.ucp_2pam.Data.Repository.Barang.LocalRepositoryBrg
import com.example.ucp_2pam.Data.Repository.Suplier.LocalRepositorySpl
import com.example.ucp_2pam.Data.Repository.Barang.RepositoryBrg
import com.example.ucp_2pam.Data.Repository.Suplier.RepositorySpl
import com.example.ucp_2pam.data.database.TokoDatabase

interface InterfaceContainerApp{
    val repositoryBrg: RepositoryBrg
    val repositorySpl: RepositorySpl
}

class ContainerApp(private val context: Context) : InterfaceContainerApp{
    override val repositoryBrg: RepositoryBrg by lazy {
        LocalRepositoryBrg(TokoDatabase.getDatabase(context).barangDao())
    }
    override val repositorySpl: RepositorySpl by lazy {
        LocalRepositorySpl(TokoDatabase.getDatabase(context).suplierDao())
    }
}