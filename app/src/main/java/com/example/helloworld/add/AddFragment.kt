package com.example.helloworld.add

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.helloworld.R
import com.example.helloworld.databinding.FragmentAddBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddFragment : Fragment() {


    @Inject
    lateinit var AddImpl: AddImpl
    // should define val not var
    private val viewModel: AddViewModel by viewModels()

    private lateinit var viewBinder : FragmentAddBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinder = FragmentAddBinding.inflate(layoutInflater)

        return viewBinder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        provideData()
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.addLiveData.observe(viewLifecycleOwner,{
            viewBinder.txtResult.text= it.toString()
        })
    }

    private fun provideData() {

        viewBinder.btn.setOnClickListener {
            viewModel.add(
                Integer.parseInt(viewBinder.edFirst.text.toString()),
                Integer.parseInt(viewBinder.edSecond.text.toString())
            )
        }


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

}