package com.example.ucp_2pam.ui.viewmodel.Barang

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp_2pam.Data.Repository.Barang.RepositoryBrg
import com.example.ucp_2pam.Entity.Barang
import kotlinx.coroutines.launch

class BarangViewModel (private val repositoryBrg: RepositoryBrg) : ViewModel() {
    var BrgUiState by mutableStateOf(BrgUiState())

    fun updateUiState(barangEvent: BarangEvent) {
        BrgUiState = BrgUiState.copy(
            barangEvent = barangEvent
        )
    }

