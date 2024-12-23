package com.example.ucp_2pam.ui.viewmodel.Suplier

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp_2pam.Data.Repository.Suplier.RepositorySpl
import com.example.ucp_2pam.Entity.Suplier
import kotlinx.coroutines.launch

class SuplierViewModel(private val repositorySup: RepositorySpl) : ViewModel() {
    var SplUiState by mutableStateOf(SuplierUiState())

    fun updateUiState(suplierEvent: SuplierEvent) {
        SplUiState = SplUiState.copy(
            suplierEvent = suplierEvent
        )
    }

