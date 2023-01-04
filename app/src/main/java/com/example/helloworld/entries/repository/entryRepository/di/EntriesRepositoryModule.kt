package com.example.helloworld.entries.repository.entryRepository.di

import com.example.helloworld.entries.repository.entryRepository.EntriesRepository
import com.example.helloworld.entries.repository.entryRepository.EntriesRepositoryImpl
import com.example.helloworld.entries.data.network.EntryApi
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
    // this goes to viewmodel coz viewmodel need EntriesReposity
    fun provideEntriesRepository(entryApi: EntryApi): EntriesRepository {

        return EntriesRepositoryImpl(entryApi)


    }

}