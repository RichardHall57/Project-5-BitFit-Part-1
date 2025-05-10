package com.example.part5bitfit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WaterEntryAdapter(private var entries: List<WaterEntry>) : RecyclerView.Adapter<WaterEntryAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dateText: TextView = view.findViewById(R.id.dateText)
        val glassesText: TextView = view.findViewById(R.id.glassesText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_entry, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = entries[position]
        holder.dateText.text = entry.date
        holder.glassesText.text = "${entry.glasses} glasses"
    }

    override fun getItemCount(): Int = entries.size

    fun updateData(newEntries: List<WaterEntry>) {
        entries = newEntries
        notifyDataSetChanged()
    }
}
