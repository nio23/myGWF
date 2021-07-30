package com.example.mygwf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MetersAdapter(private val data: List<Meter> ): RecyclerView.Adapter<MetersAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val meterId: TextView = view.findViewById(R.id.meterId)
        val comm_mod_type: TextView = view.findViewById(R.id.comm_mod_type)
        val comm_mod_serial: TextView = view.findViewById(R.id.comm_mod_serial)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.meter_row_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currentItem = data[position]
        holder.meterId.text = currentItem.meter_id.toString()
        holder.comm_mod_type.text = data[position].comm_mod_type
        holder.comm_mod_serial.text = data[position].comm_mod_serial
    }

    override fun getItemCount() = data.size


}