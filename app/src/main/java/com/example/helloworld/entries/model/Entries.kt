package com.example.helloworld.entries.model


import com.google.gson.annotations.SerializedName

data class Entries(
    @SerializedName("count")
    val count: Int,
    @SerializedName("entries")
    val entries: List<Entry>
)