package com.example.blackcoffers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter2: RecyclerView.Adapter<Adapter2.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var workProfile:TextView
        lateinit var itemName: TextView
        init{
            itemName=itemView.findViewById(R.id.user_name)
            workProfile=itemView.findViewById(R.id.tv_priority)
        }
    }

    private val name= arrayOf("Pankaj Kumar" ,"Naveen Kumar","Sourav Raturi","Lakshyadeep Patel")
    private val priority= arrayOf("UI/UX Developer | 2 Years of Experience","UI/UX Developer | 1 Year of Experience","Web Developer | 2 Years of Experience","Student")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.card_view,parent,false)
        return ViewHolder(v)

    }




    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text=name[position]
        holder.workProfile.text=priority[position]
    }

    override fun getItemCount(): Int {
        return name.size
        return priority.size
    }

}