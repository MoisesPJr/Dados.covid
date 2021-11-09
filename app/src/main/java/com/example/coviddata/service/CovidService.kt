package com.example.coviddata.service

import com.example.coviddata.feature.countries.domain.Countries
import com.example.coviddata.feature.countries.domain.Country
import com.example.coviddata.feature.States.domain.States
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface CovidService {

    //Por pais
    @GET("v1/{country}")
    fun getCountry(@Path("country") country: String): Call<Country>


    //Todos os paises
    @GET("v1/countries")
    fun getCountries(): Call<Countries>

    //Todos os estados
    @GET("v1/")
    fun getStatesBrazil(): Call<States>



}

