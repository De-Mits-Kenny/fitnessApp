package com.example.bankdrukapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.bankdrukapp.Communicator
import com.example.bankdrukapp.R

class inSessionFragment : Fragment() {

    var name: String? = ""
    var exercise: String? = ""

    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_in_session, container, false)
        communicator = activity as Communicator
        name =  arguments?.getString("name")
        exercise = arguments?.getString("exercise")

        var textName: TextView = view.findViewById(R.id.textViewNameInSession)
        textName.text = name
        var textExercise: TextView = view.findViewById(R.id.textViewExerciseInSession)
        textExercise.text = exercise

        val buttonStopSession: Button = view.findViewById(R.id.buttonStopSession)
        buttonStopSession.setOnClickListener{
            communicator.returnToStartSession()}
        return view
    }

}
