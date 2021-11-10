package com.example.coviddata.plugin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.coviddata.App
import com.example.coviddata.feature.countries.domain.Countries
import com.example.coviddata.feature.countries.domain.Country
import com.example.coviddata.repository.CovidServiceRepository
import kotlinx.coroutines.launch
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




    fun getStatsCountries() {

        viewModelScope.launch {
            try {

                val response = covidServiceRepository.getCountries()

                response.let {
                    _countries.postValue(response)
                }

            } catch (e: Exception) {
                _errorThrowable.value = e.cause
                e.printStackTrace()
            }
        }
    }
}


