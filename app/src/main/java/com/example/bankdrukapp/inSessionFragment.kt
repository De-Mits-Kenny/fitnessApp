package com.example.bankdrukapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class InSessionFragment : Fragment() {

    private var name: String? = ""
    private var exercise: String? = ""

    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_in_session, container, false)
        communicator = activity as Communicator
        name =  arguments?.getString("name")
        exercise = arguments?.getString("exercise")

        val textName: TextView = view.findViewById(R.id.textViewNameInSession)
        textName.text = name
        val textExercise: TextView = view.findViewById(R.id.textViewExerciseInSession)
        textExercise.text = exercise

        val buttonStopSession: Button = view.findViewById(R.id.buttonStopSession)
        buttonStopSession.setOnClickListener{
            communicator.returnToStartSession()}
        return view
    }

}
