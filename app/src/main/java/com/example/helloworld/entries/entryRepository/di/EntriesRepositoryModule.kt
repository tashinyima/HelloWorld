package com.example.helloworld.entries.entryRepository.di

import com.example.helloworld.entries.entryRepository.EntriesRepository
import com.example.helloworld.entries.entryRepository.EntriesRepositoryImpl
import com.example.helloworld.entries.retrofit.EntryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object EntriesRepositoryModule {

    @Singleton
    @Provides
    fun provideEntriesRepository(entryApi: EntryApi):EntriesRepository {

        return EntriesRepositoryImpl(entryApi)


    }
}