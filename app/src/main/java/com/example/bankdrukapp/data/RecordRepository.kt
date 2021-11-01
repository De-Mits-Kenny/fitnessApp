package com.example.bankdrukapp.data

import androidx.lifecycle.LiveData

class RecordRepository(private val recordDao: RecordDao) {
    val readAllData: LiveData<List<Record>> = recordDao.readAllData()

            suspend fun addRecord(record: Record){
                recordDao.addRecord(record)
            }
}