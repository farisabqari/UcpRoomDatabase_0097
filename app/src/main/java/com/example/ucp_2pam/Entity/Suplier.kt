package com.example.ucp_2pam.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "suplier")
data class Suplier(
    @PrimaryKey
    val idsuplier: String,
    val namasuplier: String,
    val kontak: String,
    val alamat: String,
)