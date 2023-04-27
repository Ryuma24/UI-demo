package com.example.blackcoffers

import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

 class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var itemName:TextView
        init{
            itemName=itemView.findViewById(R.id.user_name)
        }
    }

    private val name= arrayOf("Pankaj Kumar" ,"Naveen Kumar","Sourav Raturi","Lakshyadeep Patel")

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.card_view,parent,false)
        return ViewHolder(v)

    }




    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text=name[position]
    }

    override fun getItemCount(): Int {
        return name.size
    }




}





