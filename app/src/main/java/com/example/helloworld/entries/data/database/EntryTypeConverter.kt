package com.example.helloworld.entries.data.database

import androidx.room.TypeConverter
import com.example.helloworld.entries.model.entries.Entries
import com.example.helloworld.entries.model.entries.Entry
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


// this class is used for converting json object to string and store in db and then retrieve as string and then convert to json
class EntryTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun entriesToString(entries: Entries): String {
        return gson.toJson(entries)
    }

    // convert string to json data
    @TypeConverter
    fun stringToEntries(data: String): Entries {
        // i dont know about it
        val type = object : TypeToken<Entries>() {}.type
        return gson.fromJson(data, type)
    }


    @TypeConverter
    fun entryToString(entry: Entry): String {
        return gson.toJson(entry)
    }

    // convert string to json data
    @TypeConverter
    fun stringToEntry(data: String): Entry {
        // i dont know about it
        val type = object : TypeToken<Entry>() {}.type
        return gson.fromJson(data, type)
    }


}