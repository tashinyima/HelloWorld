package com.example.helloworld.product.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.helloworld.R
import com.example.helloworld.databinding.FragmentProductBinding
import com.example.helloworld.product.ProductDetailFragment
import com.example.helloworld.product.adapter.ProductAdapter
import com.example.helloworld.product.model.Products
import com.example.helloworld.product.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {

    private lateinit var productAdapter: ProductAdapter

   private lateinit var viewBinder :FragmentProductBinding

    private  val viewModel: ProductViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinder = FragmentProductBinding.inflate(layoutInflater)
        productAdapter = ProductAdapter(ArrayList())
        fetchData()
        initView()
        obsereLiveData()

        return viewBinder.root
    }

    private fun fetchData() {
        viewModel.fetchData()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productAdapter.onItemClick = {

            val bundle = bundleOf("product" to it)
            Log.i("IIII",bundle.toString())

            findNavController().navigate(R.id.gotoproductDetailFragment,bundle)
        }
    }

    private fun obsereLiveData() {
        viewModel.products.observe(viewLifecycleOwner, Observer {
            productAdapter.updateProduct(it)

        })


    }

    private fun initView() {
        viewBinder.rvProduct.apply {

            layoutManager = LinearLayoutManager(context)
            adapter = productAdapter
        }

    }







}