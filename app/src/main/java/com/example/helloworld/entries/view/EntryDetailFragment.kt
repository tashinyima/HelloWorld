package com.example.helloworld.entries.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.helloworld.R
import com.example.helloworld.databinding.FragmentEntryDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EntryDetailFragment : Fragment() {

    private lateinit var viewBinder: FragmentEntryDetailBinding
    private val viewModel: EntryDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinder = FragmentEntryDetailBinding.inflate(layoutInflater)
        return viewBinder.root
    }


}