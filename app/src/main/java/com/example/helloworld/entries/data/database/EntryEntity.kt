package com.example.helloworld.entries.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.helloworld.entries.model.entries.Entries
import com.example.helloworld.utils.Constant.DATABASE_NAME

@Entity(tableName = DATABASE_NAME)
class EntryEntity(var entries: Entries) {

    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}