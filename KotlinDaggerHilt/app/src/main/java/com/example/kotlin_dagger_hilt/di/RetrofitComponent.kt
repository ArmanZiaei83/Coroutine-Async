package com.example.kotlin_dagger_hilt.di

import com.example.kotlin_dagger_hilt.domain.GetRetrofitData
import com.example.kotlin_dagger_hilt.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface RetrofitComponent {
    fun inject(dataGetter : GetRetrofitData)
    fun injcet(activity : MainActivity)
}