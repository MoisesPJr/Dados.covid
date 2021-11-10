package com.example.coviddata.feature.States.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coviddata.R
import com.example.coviddata.feature.States.domain.Estado


class AdapterStates(var listData: MutableList<Estado>) : RecyclerView.Adapter<AdapterStates.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemCountry: View = LayoutInflater.from(parent.context).inflate(R.layout.item_states, parent, false)
        return MyViewHolder(itemCountry)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val state : Estado = listData[position]
        holder.nome.setText(state.state)
        holder.cases.setText("Cases: ${state.cases}")
        holder.suspect.setText("Suspects: ${state.suspect}")
        holder.deaths.setText("Deaths: ${state.deaths}")
        holder.refuses.setText("Refuses: ${state.refuses}")
        holder.date.setText("Date: ${state.dateTime}")
    }

    override fun getItemCount(): Int {
        return listData.size
    }



    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nome: TextView = itemView.findViewById(R.id.tv_name)
        var cases: TextView = itemView.findViewById(R.id.tv_cases)
        var suspect: TextView = itemView.findViewById(R.id.tv_suspect)
        var deaths: TextView = itemView.findViewById(R.id.tv_deaths)
        var refuses: TextView = itemView.findViewById(R.id.tv_refuses)
        var date: TextView = itemView.findViewById(R.id.tv_date)

    }
    init {
        this.listData = listData
    }

}
