package com.example.bankdrukapp

interface Communicator {

    fun passData(name: String, exercise: String)

    fun returnToStartSession()
}