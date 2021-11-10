package com.example.coviddata.repository

import com.example.coviddata.feature.countries.domain.Countries
import com.example.coviddata.feature.countries.domain.Country
import com.example.coviddata.feature.States.domain.States
import com.example.coviddata.service.CovidService
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


class CovidServiceRepository @Inject constructor (private val covidService: CovidService) {

    suspend fun getCountry(country:String): Country = covidService.getCountry(country)

     suspend fun getCountries(): Countries = covidService.getCountries()

     suspend fun getStates(): States = covidService.getStatesBrazil()


}