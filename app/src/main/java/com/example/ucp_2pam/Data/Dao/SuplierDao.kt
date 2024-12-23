package com.example.ucp_2pam.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ucp_2pam.Entity.Suplier
import kotlinx.coroutines.flow.Flow

@Dao
interface SuplierDao {
    @Insert
    suspend fun insertSuplier(suplier: Suplier)
    @Query("SELECT * FROM suplier ORDER BY namasuplier ASC")
    fun getAllSuplier(): Flow<List<Suplier>>
    @Query("SELECT * FROM suplier WHERE idsuplier = :id")
    fun getSuplier(id: Int): Flow<Suplier>
}