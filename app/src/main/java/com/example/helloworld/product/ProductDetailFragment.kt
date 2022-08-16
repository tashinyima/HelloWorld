package com.example.helloworld.product

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.helloworld.R
import com.example.helloworld.databinding.FragmentProductDetailBinding
import com.example.helloworld.product.model.Product
import com.example.helloworld.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {
    private lateinit var viewBinder : FragmentProductDetailBinding
 private  var product: Product? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    product = arguments?.getParcelable<Product>("product")



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

         viewBinder = FragmentProductDetailBinding.inflate(layoutInflater)
        initView()
        return viewBinder.root
    }

    private fun initView() {
        if (product!=null) {
            viewBinder.txtTitle.text = product?.title
            viewBinder.imgDetail.loadImage(product?.thumbnail)
            viewBinder.txtDescription.text= product?.description

            Toast.makeText(context,product?.images.toString(),Toast.LENGTH_LONG).show()
            Log.i("Images",product?.images.toString())
            for (images in product?.images!!){
                Log.i("Image",images)
            }
        }


    }






}