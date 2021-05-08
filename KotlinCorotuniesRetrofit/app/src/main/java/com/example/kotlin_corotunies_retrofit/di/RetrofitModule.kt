package com.example.kotlin_corotunies_retrofit.di

import com.example.kotlin_corotunies_retrofit.data.RetrofitHolder
import com.example.kotlin_corotunies_retrofit.domain.AccessData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit() : RetrofitHolder {
        return RetrofitHolder()
    }

    @Singleton
    @Provides
    fun provideAccessor() : AccessData {
        return AccessData()
    }
}