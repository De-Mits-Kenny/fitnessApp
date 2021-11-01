package com.example.bankdrukapp

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.bankdrukapp.data.Record
import com.example.bankdrukapp.data.RecordViewModel
import kotlinx.android.synthetic.main.fragment_in_session.*

class InSessionFragment : Fragment() {

    private var name: String? = ""
    private var exercise: String? = ""

    private lateinit var communicator: Communicator
    private lateinit var recordViewModel: RecordViewModel


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


        recordViewModel = ViewModelProvider(this).get(RecordViewModel::class.java)
        val buttonSubmitRecord: Button = view.findViewById(R.id.buttonSubmitRecord)
        buttonSubmitRecord.setOnClickListener{
            inserDataToDatabase()
        }

        val buttonStopSession: Button = view.findViewById(R.id.buttonStopSession)
        buttonStopSession.setOnClickListener{
            communicator.returnToStartSession()}
        return view
    }

    private fun inserDataToDatabase() {
        val nameData = name
        val exerciseData = exercise
        val kgData = editTextNumberKg.text.toString()
        val timesData = editTextNumberTimes.text.toString()

        if(inputCheck(kgData, timesData)){
            //Create record
            val record = Record(0,nameData!!, exerciseData!!, kgData.toInt(), timesData.toInt())
            //Add Data to Database
            recordViewModel.addRecord(record)
            Toast.makeText(requireContext(), "succes", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(requireContext(), "zorg dat je alles invult", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(kgData: String, timesData: String): Boolean{
        return !(TextUtils.isEmpty(kgData) && TextUtils.isEmpty(timesData))
    }

}
