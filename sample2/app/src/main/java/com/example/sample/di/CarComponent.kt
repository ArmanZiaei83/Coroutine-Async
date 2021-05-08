package com.example.sample.di

import com.example.sample.MainActivity
import dagger.Component

@Component(modules = [CarModule::class])
interface CarComponent {
    fun inject(mainActivity: MainActivity)
}