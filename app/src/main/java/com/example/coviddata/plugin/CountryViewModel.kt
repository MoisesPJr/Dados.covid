package com.example.coviddata.plugin

import android.app.Application
import androidx.lifecycle.*
import com.example.coviddata.App
import com.example.coviddata.feature.country.domain.Data
import com.example.coviddata.feature.country.domain.Teste
import com.example.coviddata.repository.CountryServiceRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject


class CountryViewModel(application: Application) : AndroidViewModel(application) {

    init {
        getApplication<App>().component.inject(this)
    }


    @Inject
    lateinit var countryServiceRepository: CountryServiceRepository


    private val _errorThrowable = MutableLiveData<Throwable>()
    val errorThrowable: LiveData<Throwable>
        get() = _errorThrowable

    private val _country = MutableLiveData<Teste>()
    val data: LiveData<Teste>
        get() = _country


    fun getCountries(country: String) {
        countryServiceRepository.getCountries(country).enqueue(object : Callback<Teste> {
            override fun onResponse(call: Call<Teste>?, response: Response<Teste>?) {

                if (response != null) {
                    _country.value = response.body()
                }

//                    response?.body()?.let {
//                        _country.postValue(
//                            listOf(
//                                Data(
//                                    it.country,
//                                    it.cases,
//                                    it.confirmed,
//                                    it.deaths,
//                                    it.recovered,
//                                    it.updatedAt
//                                )
//                            )
//                        )
//                    }
                }


            override fun onFailure(call: Call<Teste>?, t: Throwable?) {
                _country.value = null
            }

        })
    }
}


