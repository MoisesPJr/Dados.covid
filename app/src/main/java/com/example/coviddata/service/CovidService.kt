package com.example.coviddata.service

import com.example.coviddata.feature.country.domain.Data
import com.example.coviddata.feature.country.domain.Teste
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface CovidService {


    @GET("{country}")
    fun getCountries(@Path("country") country:String) : Call<Teste>


}

