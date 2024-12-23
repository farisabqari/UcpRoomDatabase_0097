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

    fun updateState(barangEvent: BarangEvent) {
        UpdateBrgUiState = UpdateBrgUiState.copy(barangEvent = barangEvent)
    }

    // Validate input fields
    fun validateFields(): Boolean {
        val event = UpdateBrgUiState.barangEvent
        val errorState = FormBrgErrorState(
            idbarang = if (event.idbarang.isEmpty()) "Id barang tidak boleh kosong" else null,
            namabarang = if (event.namabarang.isEmpty()) "Nama barang tidak boleh kosong" else null,
            deskripsi = if (event.deskripsi.isEmpty()) "Deskripsi barang tidak boleh kosong" else null,
            harga = if (event.harga <= 0) "Harga barang tidak boleh kosong atau negatif" else null,
            stok = if (event.stok <= 0) "Stok barang tidak boleh kosong atau negatif" else null,
            namasuplier = if (event.namasuplier.isEmpty()) "Nama suplier tidak boleh kosong" else null
        )

        UpdateBrgUiState = UpdateBrgUiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

