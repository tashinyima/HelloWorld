package com.example.helloworld.entries.data.database.di


import android.content.Context
import androidx.room.Room
import com.example.helloworld.entries.data.database.EntryDao
import com.example.helloworld.entries.data.database.EntryDatabase
import com.example.helloworld.utils.Constant.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class EntryDbModule {


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        EntryDatabase::class.java,
        DATABASE_NAME
    ).build()


    @Singleton
    @Provides
    fun provideDao(entryDatabase: EntryDatabase): EntryDao {
        return entryDatabase.entryDao()
    }

//    @Singleton
//    @Provides
//    fun provideDao(entryDatabase: EntryDatabase) = entryDatabase.entryDao()


}