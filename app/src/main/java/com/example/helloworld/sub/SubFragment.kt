package com.example.helloworld.sub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.helloworld.databinding.FragmentSubBinding
import com.example.helloworld.sub.SubImpl1
import com.example.helloworld.sub.SubViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SubFragment : Fragment() {
    private lateinit var viewBinder: FragmentSubBinding

    @Inject
    lateinit var subImpl1: SubImpl1
    private val viewModel: SubViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinder = FragmentSubBinding.inflate(layoutInflater)

        initListener()


        observeLiveData()

        return viewBinder.root
    }

    private fun observeLiveData() {
        viewModel.addLiveData.observe(viewLifecycleOwner, {
            viewBinder.txtResult.text = it.toString()
        })
        viewModel.subLiveData.observe(viewLifecycleOwner, {
            viewBinder.txtResult1.text = it.toString()
        })

    }

    private fun initListener() {

        viewBinder.btnSubmit.setOnClickListener {
            viewModel.sub(
                Integer.parseInt(viewBinder.et1.text.toString()),
                Integer.parseInt(viewBinder.et2.text.toString())
            )

            viewModel.add(
                Integer.parseInt(viewBinder.et1.text.toString()),
                Integer.parseInt(viewBinder.et2.text.toString())
            )


        }
    }


}




