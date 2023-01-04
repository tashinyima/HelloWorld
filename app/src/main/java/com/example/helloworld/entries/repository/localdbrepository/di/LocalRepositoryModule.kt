package com.example.helloworld.entries.repository.localdbrepository.di

import com.example.helloworld.entries.data.database.EntryDao
import com.example.helloworld.entries.repository.localdbrepository.LocaldbRepository
import com.example.helloworld.entries.repository.localdbrepository.LocaldbRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalRepositoryModule {

    @Singleton
    @Provides
    fun provideLocalRepository(entryDao: EntryDao) :LocaldbRepository{
    return LocaldbRepositoryImpl(entryDao)
    }
}