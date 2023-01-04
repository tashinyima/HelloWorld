package com.example.helloworld.entries.repository.entryRepository

import com.example.helloworld.entries.model.entries.Entries
import com.example.helloworld.entries.data.network.EntryApi
import com.example.helloworld.entries.model.entries.Entry

class EntriesRepositoryImpl(private val entryApi: EntryApi) : EntriesRepository {

    override suspend fun getEntries(): Entries {
        return entryApi.getEntries()

    }


}