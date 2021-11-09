package com.example.coviddata.repository

import com.example.coviddata.feature.countries.domain.Countries
import com.example.coviddata.feature.countries.domain.Country
import com.example.coviddata.feature.States.domain.States
import com.example.coviddata.service.CovidService
import retrofit2.Call
import javax.inject.Inject


class CovidServiceRepository @Inject constructor (private val covidService: CovidService) {

     fun getCountry(country:String): Call<Country> = covidService.getCountry(country)

     fun getCountries(): Call<Countries> = covidService.getCountries()

     fun getStates(): Call<States> = covidService.getStatesBrazil()


}