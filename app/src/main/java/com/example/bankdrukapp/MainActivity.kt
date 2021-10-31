package com.example.bankdrukapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentStartSession = startSessionFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentStartSession).commit()
    }

    override fun passData(name: String, exercise: String) {
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("exercise", exercise)
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentInSession = InSessionFragment()
        fragmentInSession.arguments = bundle
        transaction.replace(R.id.fragment_container, fragmentInSession)
        transaction.commit()
    }

    override fun returnToStartSession() {
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentStartSession = startSessionFragment()
        transaction.replace(R.id.fragment_container, fragmentStartSession)
        transaction.commit()
    }


}