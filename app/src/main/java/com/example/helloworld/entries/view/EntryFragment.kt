package com.example.helloworld.entries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.helloworld.R
import com.example.helloworld.databinding.FragmentEntryBinding
import com.example.helloworld.entries.EntriesAdapter
import com.example.helloworld.entries.entryviewmodel.EntryViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EntryFragment : Fragment() {

    private lateinit var entryAdapter: EntriesAdapter
    private lateinit var viewBinder: FragmentEntryBinding

    private val viewModel: EntryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinder = FragmentEntryBinding.inflate(layoutInflater)

        entryAdapter = EntriesAdapter(ArrayList())

        return viewBinder.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRV()
        fetchData()
        observeLiveData()

        onclickItem()

    }

    private fun onclickItem() {
        entryAdapter.onItemClick ={

            findNavController().navigate(R.id.gotoentryDetailFragment)
        }
    }

    private fun initRV() {
        viewBinder.rvEntries.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = entryAdapter
        }
    }

    private fun fetchData() {
        viewModel.retrieveEntries()

//        viewModel.entriesLiveData.observe(viewLifecycleOwner, {
//            entryAdapter.updateEntries(it.entries)
//        })
    }

    private fun observeLiveData() {
        viewModel.entriesLiveData.observe(viewLifecycleOwner) {
            entryAdapter.updateEntries(it.entries)
            viewBinder.tvTotalCount.text = it.count.toString()
        }
    }


}