package com.example.bankdrukapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface RecordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRecord (record: Record)

    @Query("SELECT * FROM Record ORDER BY id desc")
    fun readAllData(): LiveData<List<Record>>

    @Query("SELECT * FROM Record WHERE name LIKE :input OR exercise LIKE :input OR kg LIKE :input OR times LIKE :input")
    fun searchDatabase(input: String): LiveData<List<Record>>

    @Query("SELECT * FROM Record WHERE date LIKE :input")
    fun searchDatabaseOnDate(input: String): LiveData<List<Record>>

}