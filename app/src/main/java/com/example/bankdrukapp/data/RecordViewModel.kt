package com.example.bankdrukapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecordViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Record>>
    private val repository: RecordRepository

    init{
        val recordDao = RecordDatabase.getDatabase(application).recordDao()
        repository = RecordRepository(recordDao)
        readAllData = repository.readAllData
    }

    fun addRecord(record: Record){
        viewModelScope.launch(Dispatchers.IO) {
        repository.addRecord(record)
        }
    }

    fun searchDatabase(input: String): LiveData<List<Record>>{
        return repository.searchDatabase(input)
    }


    fun searchDatabaseOnDate(input: String): LiveData<List<Record>>{
        return repository.searchDatabaseOnDate(input)
    }
}