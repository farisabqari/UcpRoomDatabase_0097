package com.example.ucp_2pam.Data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Barang")
data class Barang(
    @PrimaryKey
    val id: Int = 0,
    val nama: String,
    val deskripsi: String,
    val harga: Int,
    val stok: Int,
    val namaSuplier: String

)