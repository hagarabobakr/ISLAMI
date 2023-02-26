package com.example.islami

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class SuraNameAdapter(val item: List<String>) : Adapter<SuraNameAdapter.viewHolder>() {
    class viewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val SuraName = ItemView.findViewById<TextView>(R.id.item_sura_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.SuraName.text = item[position]
        holder.itemView.setOnClickListener {
            on_item_click?.onSuraNameClick(item.get(position), position)
        }
    }

    interface onItemClick {
        fun onSuraNameClick(sura: String, position: Int)
    }

    var on_item_click: onItemClick? = null

    override fun getItemCount(): Int {
        return item.size
    }
}