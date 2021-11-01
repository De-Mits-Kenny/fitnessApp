package com.example.bankdrukapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_filter_calender.*
import kotlinx.android.synthetic.main.fragment_filter_excercise.*

class filterExcerciseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_filter_excercise, container, false)

        val buttonNavToCalender: Button = view.findViewById(R.id.buttonNavToCalender)
        buttonNavToCalender.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_filterExcerciseFragment_to_filterCalenderFragment)
        }

        return view
    }

}