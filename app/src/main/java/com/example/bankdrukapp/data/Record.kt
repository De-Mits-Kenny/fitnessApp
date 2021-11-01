package com.example.bankdrukapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*

@Entity(tableName = "Record")
data class Record (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val exercise: String,
    val kg: Int,
    val times: Int
)