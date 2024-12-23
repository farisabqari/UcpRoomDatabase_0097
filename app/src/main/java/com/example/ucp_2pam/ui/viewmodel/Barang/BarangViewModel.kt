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

    private fun validateFields(): Boolean {
        val event = BrgUiState.barangEvent
        val errorState = FormBrgErrorState(
            idbarang = if (event.idbarang.isEmpty()) "Id barang tidak boleh kosong" else null,
            namabarang = if (event.namabarang.isEmpty()) "Nama barang tidak boleh kosong" else null,
            deskripsi = if (event.deskripsi.isEmpty()) "Deskripsi barang tidak boleh kosong" else null,
            harga = if (event.harga <= 0) "Harga barang tidak boleh kosong atau negatif" else null,
            stok = if (event.stok <= 0) "Stok barang tidak boleh kosong atau negatif" else null,
            namasuplier = if (event.namasuplier.isEmpty()) "Nama suplier tidak boleh kosong" else null
        )
        BrgUiState = BrgUiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }
    fun saveData(){
        val currentEvent = BrgUiState.barangEvent

        if (validateFields()){
            viewModelScope.launch {
                try {
                    repositoryBrg.insertBarang(currentEvent.toBarangEntity())
                    BrgUiState = BrgUiState.copy(
                        snackbarMessage = "Data Berhasil Disimpan",
                        barangEvent = BarangEvent(),
                        isEntryValid = FormBrgErrorState()
                    )
                }catch (e: Exception){
                    BrgUiState = BrgUiState.copy(
                        snackbarMessage = "Data Gagal Disimpan"
                    )
                }
            }
        }else{
            BrgUiState = BrgUiState.copy(
                snackbarMessage = "Input tidak valid. Periksa kembali data Anda"
            )
        }
    }
    fun resetSnackbarMessage(){
        BrgUiState = BrgUiState.copy(
            snackbarMessage = null
        )
    }
}

