package com.example.helloworld.network

import com.example.helloworld.post.model.postmodel.JsonPostsItem
import io.reactivex.Single
import retrofit2.http.GET

interface PostApi {

    @GET("photos")
    fun getJsonPosts():Single<List<JsonPostsItem>>
}