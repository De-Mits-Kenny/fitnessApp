package com.example.bankdrukapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.bankdrukapp.databinding.ActivityMainBinding

class startSessionFragment : Fragment() {

    private lateinit var communicator: Communicator
    private lateinit var binding: ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        val view: View = inflater.inflate(R.layout.fragment_start_session, container, false)

        communicator = activity as Communicator

        val buttonStartSession: Button = view.findViewById(R.id.buttonStartSession)
        val editTextName: EditText = view.findViewById(R.id.editTextName)
        val editTextExercise: EditText = view.findViewById(R.id.editTextExercise)

        val toastMessage: String = getString(R.string.toastMessageFillIn)

        buttonStartSession.setOnClickListener{
            if (editTextExercise.text.trim().toString().isNotEmpty() && editTextName.text.trim().toString().isNotEmpty()){
                communicator.passData(editTextName.text.toString(), editTextExercise.text.toString())
            }
            else{
                Toast.makeText(activity, toastMessage, Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

}