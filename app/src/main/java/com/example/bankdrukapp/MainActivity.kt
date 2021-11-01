package com.example.bankdrukapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.example.bankdrukapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.channels.AsynchronousFileChannel.open
import java.nio.channels.DatagramChannel.open

class MainActivity : AppCompatActivity(), Communicator {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = setContentView(this, R.layout.activity_main)

        val fragmentStartSession = startSessionFragment()
        supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, fragmentStartSession).commit()

        buttonToSearch.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            startActivity(intent)
        }
    }

    override fun passData(name: String, exercise: String) {
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("exercise", exercise)
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentInSession = InSessionFragment()
        fragmentInSession.arguments = bundle
        transaction.replace(binding.fragmentContainer.id, fragmentInSession)
        transaction.commit()
    }

    override fun returnToStartSession() {
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentStartSession = startSessionFragment()
        transaction.replace(binding.fragmentContainer.id, fragmentStartSession)
        transaction.commit()
    }


}