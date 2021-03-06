package com.example.bankdrukapp


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankdrukapp.data.Record
import com.example.bankdrukapp.data.RecordViewModel
import kotlinx.android.synthetic.main.fragment_in_session.*
import kotlinx.android.synthetic.main.fragment_in_session.view.*
import java.time.LocalDate

class InSessionFragment : Fragment() {

    private var name: String? = ""
    private var exercise: String? = ""
    private var date: String = LocalDate.now().toString()

    private lateinit var communicator: Communicator
    private lateinit var recordViewModel: RecordViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //inflate the view
        val view: View = inflater.inflate(R.layout.fragment_in_session, container, false)

        //set the communicator
        communicator = activity as Communicator
        name =  arguments?.getString("name")
        exercise = arguments?.getString("exercise")

        //set the textViews
        val textName: TextView = view.findViewById(R.id.textViewNameInSession)
        textName.text = name
        val textExercise: TextView = view.findViewById(R.id.textViewExerciseInSession)
        textExercise.text = exercise

        // set the viewmodel
        recordViewModel = ViewModelProvider(this).get(RecordViewModel::class.java)


        // set the recyclerview
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recordViewModel.readAllData.observe(viewLifecycleOwner, { record ->
            adapter.setData(record)
        })

        //set buttonSubmitRecord
        val buttonSubmitRecord: Button = view.findViewById(R.id.buttonSubmitRecord)
        buttonSubmitRecord.setOnClickListener{
            insertDataToDatabase()
        }

        // set buttonStopSession
        val buttonStopSession: Button = view.findViewById(R.id.buttonStopSession)
        buttonStopSession.setOnClickListener{
            communicator.returnToStartSession()}

        return view
    }

    private fun insertDataToDatabase() {
        val nameData = name.toString()
        val exerciseData = exercise.toString()
        val kgData = editTextNumberKg.text.toString()
        val timesData = editTextNumberTimes.text.toString()
        val dateData = date

        val toastMessageFillIn: String = getString(R.string.toastMessageFillIn)
        val toastMessageSucces: String = getString(R.string.toastMessageSucces)


        if(inputCheck(kgData, timesData)){
            //Create record
            val record = Record(0,nameData, exerciseData, kgData.toInt(), timesData.toInt(),dateData)
            //Add Data to Database
            recordViewModel.addRecord(record)
            //Show toast
            Toast.makeText(requireContext(), toastMessageSucces, Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(requireContext(), toastMessageFillIn, Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(kgData: String, timesData: String): Boolean{
        return !(TextUtils.isEmpty(kgData) && TextUtils.isEmpty(timesData))
    }


}
