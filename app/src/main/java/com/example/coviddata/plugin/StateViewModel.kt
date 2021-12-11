package com.example.coviddata.plugin

import android.app.Application
import androidx.lifecycle.*
import com.example.coviddata.App
import com.example.coviddata.feature.States.domain.Estado
import com.example.coviddata.interactor.GetStatesInteractor
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


class StateViewModel(application: Application) : AndroidViewModel(application) {

    init {
        getApplication<App>().component.inject(this)
    }


    @Inject
    lateinit var getStatesInteractor: GetStatesInteractor


    private val _errorThrowable = MutableLiveData<Throwable>()
    val errorThrowable: LiveData<Throwable>
        get() = _errorThrowable

    private val _listStatesByName = MutableLiveData<List<Estado>>()
    val listStatesByName: LiveData<List<Estado>>
        get() = _listStatesByName



    fun getStatsStatesByName() {

        viewModelScope.launch {
            try{
                val response = getStatesInteractor.getStatesByName()
//                val response = getStatesInterector.getStates()

                response.let {
                    _listStatesByName.postValue(response)
                }
            }catch (e: Exception){
                _errorThrowable.value = e.cause
                e.printStackTrace()
            }
        }

    }




    fun getStatsStatesByCases() {

        viewModelScope.launch {
            try{
                val response = getStatesInteractor.getStates()
//                val response = getStatesInterector.getStates()

                response.let {
                    _listStatesByName.postValue(response)
                }
            }catch (e: Exception){
                _errorThrowable.value = e.cause
                e.printStackTrace()
            }
        }

    }







}


