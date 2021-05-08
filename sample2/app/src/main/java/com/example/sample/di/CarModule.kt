package com.example.sample.di

import com.example.sample.automobile.Car
import com.example.sample.automobile.Engine
import dagger.Module
import dagger.Provides

@Module
class CarModule {

    @Provides
    fun provideCar() : Car {
        return Car(provideEngine())
    }

    @Provides
    fun provideEngine() : Engine{
        return Engine(300 , "BMW" )
    }
}