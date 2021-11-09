package com.example.coviddata.feature.States.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coviddata.databinding.CountriesFragmentBinding
import com.example.coviddata.databinding.StatesFragmentBinding
import com.example.coviddata.feature.States.domain.Estado
import com.example.coviddata.feature.States.domain.States
import com.example.coviddata.feature.countries.domain.Countries
import com.example.coviddata.plugin.CountryViewModel
import com.example.coviddata.plugin.StateViewModel


class StatesFragment : Fragment() {


    private var _binding: StatesFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: StateViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = StatesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StateViewModel(requireActivity().application)::class.java)
        initView()
        registrationObserver()

        viewModel.getStatsStates()

    }

    private val adp by lazy {
        AdapterStates(
            listData =  mutableListOf(),
        )
    }


    private fun registrationObserver() {
        viewModel.listStates.observe(viewLifecycleOwner, countryObserver)
    }

    private val countryObserver = Observer<States> { countries ->
        if (countries != null) {
            setCountries(countries)
        }
    }

    fun setCountries(states: States) {
        adp.listData.clear()
        adp.listData.addAll(states.data)
        adp.notifyDataSetChanged()
    }

    private fun setRecyclerView() {
        val layout = LinearLayoutManager(context) as RecyclerView.LayoutManager
        with(binding.rvStates) {
            layoutManager = layout
            adapter = adp
        }
    }

    fun initView() {

        setRecyclerView()
    }
}