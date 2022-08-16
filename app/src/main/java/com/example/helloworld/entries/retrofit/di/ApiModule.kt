package com.example.helloworld.entries.retrofit.di

import com.example.helloworld.entries.model.Entries
import com.example.helloworld.entries.model.Entry
import com.example.helloworld.entries.retrofit.EntryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides

    ////  ? where u going buddy   who is calling u
    fun provideEntriesApi(retrofit: Retrofit):EntryApi {
        return retrofit.create(EntryApi::class.java)
    }

    @Singleton
    @Provides
    // providing retrofit instance to the above function ''' provideEntriesApi
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit {
       return Retrofit.Builder()
            .baseUrl("https://api.publicapis.org/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    // provide """ okHttpclient to the above function called provideRetrofit

    fun provideOkHttpClient():OkHttpClient {
        return OkHttpClient().newBuilder().build()
    }
}