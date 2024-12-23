package com.example.ucp_2pam.Data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp_2pam.ui.viewmodel.HomePageViewModel
import com.example.ucp_2pam.ui.viewmodel.PenyediaViewModel

object NamaSuplier {
    @Composable
    fun options(
        suplierHomeViewModel: HomePageViewModel = viewModel(factory = PenyediaViewModel.Factory)
    ): List<String> {
        val dataNama by suplierHomeViewModel.homeSplUiState.collectAsState()
        val namaSuplier = dataNama.listSuplier.map { it.namasuplier }
        return namaSuplier
    }
}