package com.example.helloworld.entries.repository.localdbrepository

import com.example.helloworld.entries.data.database.EntryEntity
import kotlinx.coroutines.flow.Flow

interface LocaldbRepository {

    suspend fun getLocalData(): Flow<List<EntryEntity>>
    suspend fun insertData(entryEntity: EntryEntity)
}