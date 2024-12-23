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


data class BrgUiState(
    val barangEvent: BarangEvent = BarangEvent(),
    val isEntryValid: FormBrgErrorState = FormBrgErrorState(),
    val snackbarMessage: String? = null
)

data class FormBrgErrorState(
    val idbarang: String? = null,
    val namabarang: String? = null,
    val deskripsi: String? = null,
    val harga: String? = null,
    val stok: String? = null,
    val namasuplier: String? = null
){
    fun isValid(): Boolean {
        return idbarang == null && namabarang == null && deskripsi == null &&
                harga == null && stok == null && namasuplier == null
    }
}

data class BarangEvent(
    val idbarang: String = "",
    val namabarang: String = "",
    val deskripsi: String = "",
    val harga: Int = 0,
    val stok: Int = 0,
    val namasuplier: String = ""
)

fun BarangEvent.toBarangEntity(): Barang = Barang(
    idbarang = idbarang,
    namabarang = namabarang,
    deskripsi = deskripsi,
    harga = harga,
    stok = stok,
    namasuplier = namasuplier
)