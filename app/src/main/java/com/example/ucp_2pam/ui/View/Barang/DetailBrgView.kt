package com.example.ucp_2pam.ui.View.Barang

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp_2pam.Entity.Barang
import com.example.ucp_2pam.ui.CustomWidget.TopAppBar
import com.example.ucp_2pam.ui.viewmodel.Barang.DetailBrgUiState
import com.example.ucp_2pam.ui.viewmodel.Barang.DetailBrgViewModel
import com.example.ucp_2pam.ui.viewmodel.Barang.toBarangEntity
import com.example.ucp_2pam.ui.viewmodel.PenyediaViewModel

@Composable
fun DetailBrgView(
    modifier: Modifier = Modifier,
    viewModel: DetailBrgViewModel = viewModel(factory = PenyediaViewModel.Factory),
    onBack: () -> Unit = { },
    onEditClick: (String) -> Unit,
    onDeleteClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                judul = "Detail Barang",
                showBackButton = true,
                onBack = onBack,
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEditClick(viewModel.detailBrgUiState.value.detailBrgUiEvent.idbarang)
                },
                shape = MaterialTheme.shapes.medium,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
            }
        }
    ) { innerPadding ->
        val detailBrgUiState by viewModel.detailBrgUiState.collectAsState()

        BodyDetailBrg(
            modifier = Modifier.padding(innerPadding),
            detailBrgUiState = detailBrgUiState,
            onDeleteClick = {
                viewModel.deleteBrg()
                onDeleteClick()
            }
        )
    }
}

@Composable
fun BodyDetailBrg(
    modifier: Modifier = Modifier,
    detailBrgUiState: DetailBrgUiState,
    onDeleteClick: () -> Unit
) {
    var deleteConfirmationRequired by rememberSaveable { mutableStateOf(false) }

    when {
        detailBrgUiState.isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            }
        }

        detailBrgUiState.isUiEventNotEmpty -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 24.dp)
            ) {
                ItemDetailBrg(
                    barang = detailBrgUiState.detailBrgUiEvent.toBarangEntity(),
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { deleteConfirmationRequired = true },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error,
                        contentColor = MaterialTheme.colorScheme.onError
                    )
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Hapus")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Hapus Data")
                }

                if (deleteConfirmationRequired) {
                    DeleteConfirmationDialog(
                        onDeleteConfirm = {
                            deleteConfirmationRequired = false
                            onDeleteClick()
                        },
                        onDeleteCancel = { deleteConfirmationRequired = false },
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }

        detailBrgUiState.isUiEventEmpty -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Data Tidak Ditemukan",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                )
            }
        }
    }
}

@Composable
fun ItemDetailBrg(
    modifier: Modifier = Modifier,
    barang: Barang
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            ComponentDetailBarang(judul = "Id Barang", isi = barang.idbarang)
            Spacer(modifier = Modifier.height(12.dp))
            ComponentDetailBarang(judul = "Nama Barang", isi = barang.namabarang)
            Spacer(modifier = Modifier.height(12.dp))
            ComponentDetailBarang(judul = "Harga", isi = barang.harga.toString())
            Spacer(modifier = Modifier.height(12.dp))
            ComponentDetailBarang(judul = "Stok", isi = barang.stok.toString())
            Spacer(modifier = Modifier.height(12.dp))
            ComponentDetailBarang(judul = "Deskripsi", isi = barang.deskripsi)
            Spacer(modifier = Modifier.height(12.dp))
            ComponentDetailBarang(judul = "Id Suplier", isi = barang.namasuplier)
        }
    }
}

