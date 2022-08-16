package com.example.helloworld.product.model

import com.google.gson.annotations.SerializedName


class Products (
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("products")
    val products: List<Product>,
    @SerializedName("skip")
    val skip: Int,
    @SerializedName("total")
    val total: Int
    )
   
