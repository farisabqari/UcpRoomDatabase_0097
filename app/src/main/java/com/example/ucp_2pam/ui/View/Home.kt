package com.example.ucp_2pam.ui.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp_2pam.R
import com.example.ucp_2pam.ui.CostumeWdget.HomeBar

@Composable
fun Home(
    onBarangClick: () -> Unit,
    onTambahBarangClick: () -> Unit,
    onSuplierClick: () -> Unit,
    onTambahSuplierClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            HomeBar(
                showBackButton = false,
                onBack = { },
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color.White)
            ) {
                // Header teks di atas kartu
                HeaderText()

                // Kolom dengan tampilan kartu menumpuk ke bawah
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp) // Spasi antar kartu
                ) {
                    // Tambah Barang
                    CardItem(
                        title = "TAMBAH BARANG",
                        backgroundColor = Color(0xFF6366AE),
                        iconRes = R.drawable.tambahbarang,
                        onClick = onTambahBarangClick
                    )
                    // Barang List
                    CardItem(
                        title = "DAFTAR BARANG",
                        backgroundColor = Color(0xFF6366AE),
                        iconRes = R.drawable.listbarang,
                        onClick = onBarangClick
                    )
                    // Tambah Suplier
                    CardItem(
                        title = "TAMBAH SUPLIER",
                        backgroundColor = Color(0xFF6366AE),
                        iconRes = R.drawable.tambahsuplier,
                        onClick = onTambahSuplierClick
                    )
                    // Suplier List
                    CardItem(
                        title = "DAFTAR SUPLIER",
                        backgroundColor = Color(0xFF6366AE),
                        iconRes = R.drawable.listsuplier,
                        onClick = onSuplierClick
                    )
                }
            }
        }
    )
}

@Composable
fun HeaderText() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Aplikasi Pengolahan Barang",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Kelola data barang dan suplier dengan mudah.",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun CardItem(
    title: String,
    backgroundColor: Color,
    iconRes: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        // Gambar memenuhi seluruh kartu
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            contentScale = ContentScale.Crop, // Gambar akan memenuhi kartu dan menyesuaikan proporsi
            modifier = Modifier
                .fillMaxSize() // Gambar memenuhi seluruh ukuran kartu
                .background(Color.Transparent),
            alpha = 0.5f // Transparansi 50%
        )

        // Teks di atas gambar
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center) // Teks di tengah kartu
        )
    }
}
