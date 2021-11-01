package com.example.bankdrukapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankdrukapp.data.RecordViewModel
import kotlinx.android.synthetic.main.fragment_filter_calender.*
import kotlinx.android.synthetic.main.fragment_filter_calender.view.*
import kotlinx.android.synthetic.main.fragment_filter_excercise.view.*


class filterCalenderFragment : Fragment() {

    private lateinit var recordViewModel: RecordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_filter_calender, container, false)

        val buttonNavToSearch: Button = view.findViewById(R.id.buttonNavToSearch)
        buttonNavToSearch.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_filterCalenderFragment_to_filterExcerciseFragment)
        }

        // set the viewmodel
        recordViewModel = ViewModelProvider(this).get(RecordViewModel::class.java)


        // set the recyclerview
        val adapter = ListAdapter()
        val recyclerView = view.recyclerCalender
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recordViewModel.readAllData.observe(viewLifecycleOwner, Observer { record ->
            adapter.setData(record)
        })

        return view
    }

}