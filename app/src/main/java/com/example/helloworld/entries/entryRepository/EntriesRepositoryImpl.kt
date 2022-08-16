package com.example.helloworld.entries.entryRepository

import com.example.helloworld.entries.model.Entries
import com.example.helloworld.entries.retrofit.EntryApi

class EntriesRepositoryImpl(private val entryApi: EntryApi) : EntriesRepository {
    override suspend fun getEntries(): Entries {

        return entryApi.getEntries()

    }
}