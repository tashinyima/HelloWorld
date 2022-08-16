package com.example.helloworld.product.retrofit

import com.example.helloworld.product.model.Product
import com.example.helloworld.product.model.Products
import com.example.helloworld.utils.Constant.PRODUCT_URL
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ProductApiService {

    private val api = Retrofit.Builder()
        .baseUrl(PRODUCT_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ProductApi::class.java)


//    fun getProduct():Single<List<Product>>{
//        return api.getProduct()
//    }

    fun getProducts():Call<Products>{
        return api.getProduct()
    }


}