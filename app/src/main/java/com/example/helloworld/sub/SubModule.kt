package com.example.helloworld.sub

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object SubModule {
    @Provides
    fun provideSub() :Sub {
        return SubImpl1()
    }

}