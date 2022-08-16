package com.example.helloworld.network

import com.example.helloworld.post.model.postmodel.JsonPostsItem
import com.example.helloworld.utils.Constant.BASE_URL
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PostApiService {


    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(PostApi::class.java)

    fun getPost():Single<List<JsonPostsItem>>{
        return api.getJsonPosts()
    }

}