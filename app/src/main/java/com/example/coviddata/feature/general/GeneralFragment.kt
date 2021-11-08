package com.example.coviddata.feature.general

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.coviddata.R
import com.example.coviddata.feature.country.domain.Data
import com.example.coviddata.feature.country.domain.Teste
import com.example.coviddata.plugin.CountryViewModel


class GeneralFragment : Fragment() {


    private lateinit var viewModel: CountryViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_general, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

     viewModel = ViewModelProviders.of(this).get(CountryViewModel(requireActivity().application)::class.java)
        registrationObserver()

        viewModel.getCountries("brazil")

    }

    private fun registrationObserver(){
        viewModel.data.observe(viewLifecycleOwner,countryObserver )
    }

    private val countryObserver = Observer<Teste>{ country ->

    if(country != null){
    }

    }
}