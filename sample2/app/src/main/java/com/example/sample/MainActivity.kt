package com.example.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sample.automobile.Car
import com.example.sample.di.CarComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var component : CarComponent

    @Inject
    lateinit var car : Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component = Dagger
    }
}