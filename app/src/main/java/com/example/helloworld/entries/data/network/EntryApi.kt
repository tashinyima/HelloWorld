package com.example.helloworld.entries.data.network

import com.example.helloworld.entries.model.entries.Entries
import com.example.helloworld.entries.model.entries.Entry
import retrofit2.http.GET

interface EntryApi {
    @GET("entries")
    suspend fun getEntries(): Entries
    @GET("entries")
    suspend fun getEntry():Entry
}