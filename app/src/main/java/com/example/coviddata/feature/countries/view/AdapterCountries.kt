package com.example.coviddata.feature.countries.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coviddata.R
import com.example.coviddata.feature.countries.domain.Country


class AdapterCountries(var listData: MutableList<Country>) : RecyclerView.Adapter<AdapterCountries.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemCountry: View = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return MyViewHolder(itemCountry)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val country : Country = listData[position]
        holder.nome.setText(country.country)
        holder.cases.setText(country.cases.toString())
        holder.confirmed.setText(country.confirmed.toString())
        holder.deaths.setText(country.deaths.toString())
        holder.recovered.setText(country.recovered.toString())
        holder.date.setText(country.updatedAt.toString())
    }

    override fun getItemCount(): Int {
        return listData.size
    }



    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nome: TextView = itemView.findViewById(R.id.tv_name)
        var cases: TextView = itemView.findViewById(R.id.tv_cases)
        var confirmed: TextView = itemView.findViewById(R.id.tv_confirmed)
        var deaths: TextView = itemView.findViewById(R.id.tv_deaths)
        var recovered: TextView = itemView.findViewById(R.id.tv_recovered)
        var date: TextView = itemView.findViewById(R.id.tv_date)

    }
    init {
        this.listData = listData
    }

}
