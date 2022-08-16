package com.example.helloworld.add

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class AddModule {
    @Provides
    fun provideAdd():Add {
        return AddImpl()
    }
}