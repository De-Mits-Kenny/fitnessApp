package com.example.bankdrukapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankdrukapp.data.RecordViewModel
import kotlinx.android.synthetic.main.fragment_filter_excercise.view.*

class filterExcerciseFragment : Fragment() {

    private lateinit var recordViewModel: RecordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_filter_excercise, container, false)

        // set the navigation to the other fragment
        val buttonNavToCalender: Button = view.findViewById(R.id.buttonNavToCalender)
        buttonNavToCalender.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_filterExcerciseFragment_to_filterCalenderFragment)
        }

        // set the viewmodel
        recordViewModel = ViewModelProvider(this).get(RecordViewModel::class.java)


        // set the recyclerview
        val adapter = ListAdapter()
        val recyclerView = view.recyclerSearch
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recordViewModel.readAllData.observe(viewLifecycleOwner,  { record ->
            adapter.setData(record)
        })

        // change the recyclerview when you search
        val editTextInput: EditText = view.findViewById(R.id.editTextSearch)
        val input = editTextInput.text
        val buttonSearch: Button = view.findViewById(R.id.buttonSearch)
        buttonSearch.setOnClickListener{
            recordViewModel.searchDatabase("%$input%").observe(viewLifecycleOwner,  { record ->
                adapter.setData(record)
        })
        }
        return view
    }
}