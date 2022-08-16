package com.example.helloworld.entries.retrofit

import com.example.helloworld.entries.model.Entries
import retrofit2.http.GET

interface EntryApi {

    @GET("entries")
  suspend fun getEntries():Entries
}