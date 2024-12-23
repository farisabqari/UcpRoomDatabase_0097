package com.example.ucp_2pam.ui.viewmodel.Barang

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp_2pam.Data.Repository.Barang.RepositoryBrg
import com.example.ucp_2pam.Entity.Barang
import com.example.ucp_2pam.ui.Navigasi.DestinasiUpdate
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class UpdateBrgViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryBrg: RepositoryBrg,
) : ViewModel() {

    var UpdateBrgUiState by mutableStateOf(BrgUiState())
        private set

    private val barangId: String = checkNotNull(savedStateHandle[DestinasiUpdate.idBarang])

    init {
        viewModelScope.launch {
            UpdateBrgUiState = repositoryBrg.getBarang(barangId)
                .filterNotNull()
                .first()
                .toUIStateBrg()
        }
    }
