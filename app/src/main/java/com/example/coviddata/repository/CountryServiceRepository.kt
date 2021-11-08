package com.example.coviddata.repository

import com.example.coviddata.feature.country.domain.Data
import com.example.coviddata.feature.country.domain.Teste
import com.example.coviddata.service.CovidService
import retrofit2.Call
import javax.inject.Inject


class CountryServiceRepository @Inject constructor (private val covidService: CovidService) {

     fun getCountries(country:String): Call<Teste> = covidService.getCountries(country)

}