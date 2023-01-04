package com.example.helloworld.entries.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface EntryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)  // replace with new data if there is conflict...
    suspend fun insertEntries(entryEntity: EntryEntity)

    // here used the flow and it should be live data but at the view model we wil convert to livedata using " asLiveData extension
    @Query("SELECT*FROM entries_db ORDER BY id ASC ")
    fun fetchEntries(): Flow<List<EntryEntity>>
}