package com.example.xmlformatassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_students.view.*

class RVstudents(var studentsArray: ArrayList<String>): RecyclerView.Adapter<RVstudents.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_students, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val another = studentsArray[position]
        holder.itemView.apply{
            tvStudents.text = another
        }
    }

    override fun getItemCount()= studentsArray.size
}