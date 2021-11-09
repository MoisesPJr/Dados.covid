package com.example.coviddata.plugin

import android.app.Application
import androidx.lifecycle.*
import com.example.coviddata.App
import com.example.coviddata.feature.States.domain.States
import com.example.coviddata.repository.CovidServiceRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject


class StateViewModel(application: Application) : AndroidViewModel(application) {

    init {
        getApplication<App>().component.inject(this)
    }


    @Inject
    lateinit var covidServiceRepository: CovidServiceRepository


    private val _errorThrowable = MutableLiveData<Throwable>()
    val errorThrowable: LiveData<Throwable>
        get() = _errorThrowable

    private val _listStates = MutableLiveData<States>()
    val listStates: LiveData<States>
        get() = _listStates


    fun getStatsStates() {
        covidServiceRepository.getStates().enqueue(object : Callback<States> {
            override fun onResponse(call: Call<States>?, response: Response<States>?) {
                try {
                    if (response != null) {
                        _listStates.value = response.body()
                    }
                } catch (e: Exception) {
                    _errorThrowable.value = e.cause
                }

            }

            override fun onFailure(call: Call<States>?, t: Throwable?) {
                _listStates.value = null
                if (t != null) {
                    _errorThrowable.value = t.cause
                }
            }
        })
    }







}


