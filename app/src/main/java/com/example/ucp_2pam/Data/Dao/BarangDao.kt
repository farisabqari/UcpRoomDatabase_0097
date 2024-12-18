package com.example.ucp_2pam.Data.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ucp_2pam.Data.Entity.Barang
    import kotlinx.coroutines.flow.Flow


@Dao
interface BarangDao {
    @Insert
    suspend fun insertBarang(barang: Barang)

    @Query("SELECT * FROM barang")
    suspend fun getAllBarang(): List<Barang>

    @Update
    suspend fun updateBarang(barang: Barang)

    @Delete
    suspend fun deleteBarang(barang: Barang)

    @Query("SELECT * FROM barang WHERE id = :id")
    suspend fun getDetailBarang(id: Int): Barang
}
