package com.example.helloworld.entries.view

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
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
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.search_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return true
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return viewBinder.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRV()
        readDatabase()
        onclickItem()

    }

    private fun readDatabase() {
        viewModel.load()

        viewModel.readEntry.observe(viewLifecycleOwner, { database ->
            if (database.isNotEmpty()) {

                Log.d("EntryFragment", "Requested data from local db ")
                val entries = database[0].entries.entries

                entryAdapter.updateEntries(entries)


            } else {
                requestApiData()

            }

        })
    }


    private fun onclickItem() {
        entryAdapter.onItemClick = {

            findNavController().navigate(R.id.gotoentryDetailFragment)
        }
    }

    private fun initRV() {
        viewBinder.rvEntries.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = entryAdapter
        }
    }

    private fun requestApiData() {
        Log.d("EntryFragment", "RequestedApi data called ")



        viewModel.retrieveEntries()
        observeLiveData()


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