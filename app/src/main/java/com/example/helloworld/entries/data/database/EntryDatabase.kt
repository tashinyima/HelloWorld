package com.example.helloworld.entries.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [EntryEntity::class],
    version = 1,
    exportSchema = false  // by default it is true
)

@TypeConverters(EntryTypeConverter::class)  // ???? i don't know why
abstract class EntryDatabase() : RoomDatabase(){
    abstract fun entryDao(): EntryDao
}