package com.example.helloworld.product.retrofit

import com.example.helloworld.product.model.Product
import com.example.helloworld.product.model.Products
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
   // fun getProduct(): Single<List<Product>>
    fun getProduct():Call<Products>



}