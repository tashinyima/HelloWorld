package com.example.helloworld.post.network

import com.example.helloworld.post.model.JsonPosts
import com.example.helloworld.post.model.JsonPostsItem
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface PostApi {

    @GET("photos")
    fun getJsonPosts():Single<List<JsonPostsItem>>
}