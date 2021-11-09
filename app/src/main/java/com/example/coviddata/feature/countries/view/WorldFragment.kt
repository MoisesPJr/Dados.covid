package com.example.coviddata.feature.countries.view

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
import com.example.coviddata.feature.countries.domain.Countries
import com.example.coviddata.plugin.CountryViewModel


class WorldFragment : Fragment() {


    private var _binding: CountriesFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CountryViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CountriesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CountryViewModel(requireActivity().application)::class.java)
        initView()
        registrationObserver()

        viewModel.getStatsCountries()

    }

    private val adp by lazy {
        AdapterCountries(
            listData =  mutableListOf(),
        )
    }


    private fun registrationObserver() {
        viewModel.listCountries.observe(viewLifecycleOwner, countryObserver)
    }

    private val countryObserver = Observer<Countries> { countries ->
        if (countries != null) {
            setCountries(countries)
        }
    }

    fun setCountries(countries: Countries) {
        adp.listData.clear()
        adp.listData.addAll(countries.data)
        adp.notifyDataSetChanged()
    }

    private fun setRecyclerView() {
        val layout = LinearLayoutManager(context) as RecyclerView.LayoutManager
        with(binding.rvCountries) {
            layoutManager = layout
            adapter = adp
        }
    }

    fun initView() {

        setRecyclerView()
    }
}