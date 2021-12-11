package com.example.coviddata.feature.States.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coviddata.R
import com.example.coviddata.databinding.StatesFragmentBinding
import com.example.coviddata.feature.States.domain.Estado
import com.example.coviddata.plugin.StateViewModel
import androidx.appcompat.app.AppCompatActivity





class StatesFragment : Fragment() {


    private var _binding: StatesFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: StateViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = StatesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        registrationObserver()

        viewModel.getStatsStatesByCases()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.states_menu, menu)
        return super.onCreateOptionsMenu(menu,inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuAlpha ->{
                viewModel.getStatsStatesByName()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private val adp by lazy {
        AdapterStates(
            listData = mutableListOf(),
        )
    }


    private fun registrationObserver() {
        viewModel.listStatesByName.observe(viewLifecycleOwner, statesObserver)
    }

    private val statesObserver = Observer<List<Estado>> { states ->
        if (states != null) {
            setCountries(states)
        }
    }

    fun setCountries(states: List<Estado>) {
        adp.listData.clear()
        adp.listData.addAll(states)
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