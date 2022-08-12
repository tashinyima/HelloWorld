package com.example.helloworld.multi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.helloworld.R
import com.example.helloworld.databinding.FragmentMultiplicationBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MultiplicationFragment : Fragment() {

    private lateinit var viewBinder : FragmentMultiplicationBinding

    @Inject
     lateinit var multiplicationImpl: MultiplicationImpl

    private val viewModel : MultiplicationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewBinder = FragmentMultiplicationBinding.inflate(layoutInflater)
        initListener()
        observeData()
        ShowMessage("Rey rey")

        return viewBinder.root
    }

    private fun observeData() {
        viewModel.multiLiveData.observe(viewLifecycleOwner,{
            viewBinder.txtResult.text = it.toString()
        })
    }

    private fun initListener() {
        viewBinder.btnSubmit.setOnClickListener {

            viewModel.multiply(viewBinder.edName.text.toString(),
                Integer.parseInt(viewBinder.edAge.text.toString()))
        }
    }


    private fun ShowMessage(msg : String) {

        Toast.makeText(requireContext(),msg,Toast.LENGTH_LONG).show()
    }


}