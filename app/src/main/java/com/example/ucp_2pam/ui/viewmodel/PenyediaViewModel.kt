package com.example.ucp_2pam.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp_2pam.TokoApp
import com.example.ucp_2pam.ui.viewmodel.Barang.BarangViewModel
import com.example.ucp_2pam.ui.viewmodel.Barang.DetailBrgViewModel
import com.example.ucp_2pam.ui.viewmodel.Barang.HomeBrgViewModel
import com.example.ucp_2pam.ui.viewmodel.Barang.UpdateBrgViewModel
import com.example.ucp_2pam.ui.viewmodel.Suplier.HomeSplViewModel
import com.example.ucp_2pam.ui.viewmodel.Suplier.SuplierViewModel


object PenyediaViewModel{

    val Factory = viewModelFactory {
        initializer {
            HomePageViewModel(
                TokoApp().containerApp.repositoryBrg,
                TokoApp().containerApp.repositorySpl
            )
        }
        initializer {
            HomeBrgViewModel(
                TokoApp().containerApp.repositoryBrg
            )
        }
        initializer {
            HomeSplViewModel(
                TokoApp().containerApp.repositorySpl
            )
        }
        initializer {
            BarangViewModel(
                TokoApp().containerApp.repositoryBrg,
            )
        }
        initializer {
            DetailBrgViewModel(
                createSavedStateHandle(),
                TokoApp().containerApp.repositoryBrg,
            )
        }
        initializer {
            UpdateBrgViewModel(
                createSavedStateHandle(),
                TokoApp().containerApp.repositoryBrg,
            )
        }
        initializer {
            SuplierViewModel(
                TokoApp().containerApp.repositorySpl
            )
        }
    }
}

fun CreationExtras.TokoApp() : TokoApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TokoApp)