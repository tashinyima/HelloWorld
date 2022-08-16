package com.example.helloworld.entries.entryRepository

import com.example.helloworld.entries.model.Entries

interface EntriesRepository {
    suspend fun getEntries():Entries
}