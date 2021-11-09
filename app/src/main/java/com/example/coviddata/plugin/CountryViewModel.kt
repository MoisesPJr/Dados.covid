package com.example.coviddata.plugin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coviddata.App
import com.example.coviddata.feature.countries.domain.Countries
import com.example.coviddata.feature.countries.domain.Country
import com.example.coviddata.repository.CovidServiceRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class CountryViewModel(application: Application) : AndroidViewModel(application) {

    init {
        getApplication<App>().component.inject(this)
    }


    @Inject
    lateinit var covidServiceRepository: CovidServiceRepository


    private val _errorThrowable = MutableLiveData<Throwable>()
    val errorThrowable: LiveData<Throwable>
        get() = _errorThrowable

    private val _country = MutableLiveData<Country>()
    val country: LiveData<Country>
        get() = _country


    private val _countries = MutableLiveData<Countries>()
    val listCountries: LiveData<Countries>
        get() = _countries


    fun getStatsCountry(country: String) {
        covidServiceRepository.getCountry(country).enqueue(object : Callback<Country> {
            override fun onResponse(call: Call<Country>?, response: Response<Country>?) {
                try {
                    if(response != null){
                        _country.value = response.body()
                    }
                }catch (e: Exception){
                    _errorThrowable.value = e.cause
                }

            }
            override fun onFailure(call: Call<Country>?, t: Throwable?) {
                if (t != null) {
                    _errorThrowable.value = t.cause
                }
            }
        })
    }

    fun getStatsCountries() {
        covidServiceRepository.getCountries().enqueue(object : Callback<Countries> {
            override fun onResponse(call: Call<Countries>?, response: Response<Countries>?) {
               try {
                   if (response != null) {
                       _countries.value = response.body()
                   }
               }catch (e: Exception){
                   _errorThrowable.value = e.cause
               }
            }

            override fun onFailure(call: Call<Countries>?, t: Throwable?) {
                if (t != null) {
                    _errorThrowable.value = t.cause
                }
            }

        })
    }


}


