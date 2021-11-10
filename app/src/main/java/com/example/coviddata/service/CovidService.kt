package com.example.coviddata.service

import com.example.coviddata.feature.States.domain.States
import com.example.coviddata.feature.countries.domain.Countries
import com.example.coviddata.feature.countries.domain.Country
import retrofit2.http.GET
import retrofit2.http.Path


interface CovidService {

    //Por pais
    @GET("v1/{country}")
   suspend fun getCountry(@Path("country") country: String):Country


    //Todos os paises
    @GET("v1/countries")
    suspend fun getCountries(): Countries

    //Todos os estados
    @GET("v1/")
    suspend fun getStatesBrazil(): States



}

