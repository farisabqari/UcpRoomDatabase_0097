package com.example.ucp_2pam.Data.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ucp_2pam.Data.Entity.Suplier
import kotlinx.coroutines.flow.Flow

@Dao
interface SuplierDao {
    @Insert
    suspend fun insertSuplier(suplier: Suplier)

    @Query("SELECT * FROM suplier")
    suspend fun getAllSuplier(): List<Suplier>
}
