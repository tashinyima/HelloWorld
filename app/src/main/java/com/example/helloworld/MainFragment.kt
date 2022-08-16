package com.example.helloworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.helloworld.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var viewBinder: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinder = FragmentMainBinding.inflate(layoutInflater)
        initView()
        return viewBinder.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinder.textView.text ="Welcome to self study "
        //view.findViewById<TextView>(R.id.textView).text="Thom Thom"
    }

    private fun initView() {
        viewBinder.btnSub.setOnClickListener {
            findNavController().navigate(R.id.gotoSubFragment)
        }
        viewBinder.multibtn.setOnClickListener {
            findNavController().navigate(R.id.gotomultiplicationFragment)
        }
        viewBinder.postbtn.setOnClickListener {
            findNavController().navigate(R.id.gotopostFragment)
        }
        viewBinder.productbtn.setOnClickListener {
            findNavController().navigate(R.id.gotoproductFragment)
        }

        viewBinder.addbtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_addFragment)
        }

        viewBinder.getJson.setOnClickListener {
            findNavController().navigate(R.id.gotoentryFragment)

        }
    }


}