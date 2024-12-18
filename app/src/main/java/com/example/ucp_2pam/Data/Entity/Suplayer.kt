package com.example.ucp_2pam.Data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Suplier")
data class Suplier(
    @PrimaryKey
    val id: Int = 0,
    val nama: String,
    val kontak: String,
    val alamat: String,

    )