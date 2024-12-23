package com.example.ucp_2pam.ui.View.Suplier

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp_2pam.ui.CustomWidget.TopAppBar
import com.example.ucp_2pam.ui.viewmodel.PenyediaViewModel
import com.example.ucp_2pam.ui.viewmodel.Suplier.FormSplErrorState
import com.example.ucp_2pam.ui.viewmodel.Suplier.SuplierEvent
import com.example.ucp_2pam.ui.viewmodel.Suplier.SuplierUiState
import com.example.ucp_2pam.ui.viewmodel.Suplier.SuplierViewModel
import kotlinx.coroutines.launch

@Composable
fun InsertSplView (
    onBack: () -> Unit,
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SuplierViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val uiState = viewModel.SplUiState
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(uiState.snackbarMessage) {
        uiState.snackbarMessage?.let { message ->
            coroutineScope.launch {
                snackbarHostState.showSnackbar(message)
                viewModel.resetSnackbarMessage()
            }
        }
    }

    Scaffold(
        Modifier, snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { it
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopAppBar(
                onBack = onBack,
                showBackButton = true,
                judul = "Tambah Suplier"
            )
            InsertBodySpl(
                uiState = uiState,
                onValueChange = { updateEvent ->
                    viewModel.updateUiState(updateEvent)
                },
                onClick = {
                    viewModel.saveData()
                    onNavigate()
                }
            )
        }
    }
}

@Composable
fun InsertBodySpl(
    modifier: Modifier = Modifier,
    onValueChange: (SuplierEvent) -> Unit,
    uiState: SuplierUiState,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormSuplier(
            suplierEvent = uiState.suplierEvent,
            onValueChange = onValueChange,
            errorState = uiState.isEntryValid,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(text = "Simpan")
        }
    }
}
