package com.example.bankdrukapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankdrukapp.data.Record
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var recordList = emptyList<Record>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = recordList[position]
        holder.itemView.recycleName.text = currentItem.name.toString()
        holder.itemView.recycleExersize.text = currentItem.exercise.toString()
        holder.itemView.recycleKg.text = currentItem.kg.toString() + " Kg"
        holder.itemView.recycleTimes.text = currentItem.times.toString() + " X"
    }

    override fun getItemCount(): Int {
        return recordList.size
    }

    fun setData(record: List<Record>){
        this.recordList = record
        notifyDataSetChanged()
    }


}