package com.example.coviddata.plugin

import android.app.Application
import androidx.lifecycle.*
import com.example.coviddata.App
import com.example.coviddata.feature.States.domain.States
import com.example.coviddata.repository.CovidServiceRepository
import kotlinx.coroutines.launch
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

        viewModelScope.launch {
            try{
                val response = covidServiceRepository.getStates()

                response.let {
                    _listStates.postValue(response)
                }
            }catch (e: Exception){
                _errorThrowable.value = e.cause
                e.printStackTrace()
            }
        }

    }







}


