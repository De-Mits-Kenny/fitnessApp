package com.example.bankdrukapp.data

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.bankdrukapp.R

class RecordRepository(private val recordDao: RecordDao) {

    val readAllData: LiveData<List<Record>> = recordDao.readAllData()

    suspend fun addRecord(record: Record){
        recordDao.addRecord(record)
    }


    fun searchDatabase(input: String): LiveData<List<Record>>{
        return recordDao.searchDatabase(input)
    }


    fun searchDatabaseOnDate(input: String): LiveData<List<Record>>{
        return recordDao.searchDatabaseOnDate(input)
    }
}