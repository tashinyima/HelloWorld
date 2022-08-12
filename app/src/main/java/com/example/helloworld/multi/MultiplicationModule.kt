package com.example.helloworld.multi

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object MultiplicationModule {
    @Provides
    fun ProvideMultiplication()  : Multiplication {
        return MultiplicationImpl()
    }

}