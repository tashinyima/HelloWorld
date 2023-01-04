package com.example.helloworld.entries.repository.localdbrepository

import com.example.helloworld.entries.data.database.EntryDao
import com.example.helloworld.entries.data.database.EntryEntity
import kotlinx.coroutines.flow.Flow

class LocaldbRepositoryImpl(private val entryDao: EntryDao) : LocaldbRepository {

    override suspend fun getLocalData(): Flow<List<EntryEntity>> {
        return entryDao.fetchEntries()
    }
//
    override suspend fun insertData(entryEntity: EntryEntity) {
        entryDao.insertEntries(entryEntity)
    }


}