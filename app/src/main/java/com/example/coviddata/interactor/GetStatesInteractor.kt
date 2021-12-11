package com.example.coviddata.interactor

import com.example.coviddata.feature.States.domain.Estado
import com.example.coviddata.repository.CovidServiceRepository
import javax.inject.Inject

class GetStatesInteractor @Inject constructor(private val repository: CovidServiceRepository) {
    suspend fun getStates(): List<Estado> = repository.getStates().data.sortedByDescending { it.cases  }

    suspend fun getStatesByName(): List<Estado> = repository.getStates().data.sortedBy { it.state  }

}