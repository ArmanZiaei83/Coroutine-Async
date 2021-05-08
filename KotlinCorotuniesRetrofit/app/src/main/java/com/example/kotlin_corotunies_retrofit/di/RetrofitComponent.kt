package com.example.kotlin_corotunies_retrofit.di

import com.example.kotlin_corotunies_retrofit.app.MainActivity
import com.example.kotlin_corotunies_retrofit.domain.AccessData
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(RetrofitModule::class))
interface RetrofitComponent {

    fun inject(dataAccess : AccessData)
    fun inject(main : MainActivity)
}