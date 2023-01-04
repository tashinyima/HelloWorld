package com.example.helloworld.entries.repository.entryRepository

import com.example.helloworld.entries.model.entries.Entries
import com.example.helloworld.entries.model.entries.Entry


interface EntriesRepository {

    suspend fun getEntries():Entries

}