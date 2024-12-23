package com.example.ucp_2pam.ui.CustomWidget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp_2pam.R

@Composable
fun TopAppBar(
    onBack: () -> Unit,
    showBackButton: Boolean = true,
    judul: String,
) {
    val backgroundColor = Color(0xFF6366AE)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(backgroundColor)
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        if (showBackButton) {
            IconButton(
                onClick = onBack,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(top = 40.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Kembali",
                    tint = Color.White
                )
            }
        }

        Text(
            text = judul,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 40.dp)
        )

        Icon(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.CenterEnd)
                .padding(top = 23.dp, end = 5.dp) // Penyesuaian posisi logo
        )
    }
}
