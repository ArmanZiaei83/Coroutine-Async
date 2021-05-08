package com.example.kotlin_dagger_hilt.di

import com.example.kotlin_dagger_hilt.data.remote.RetrofitHolder
import com.example.kotlin_dagger_hilt.domain.GetRetrofitData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun getRetrofit() : RetrofitHolder {
        return RetrofitHolder()
    }

    @Singleton
    @Provides
    fun provideGetter() : GetRetrofitData {
        return GetRetrofitData()
    }

}