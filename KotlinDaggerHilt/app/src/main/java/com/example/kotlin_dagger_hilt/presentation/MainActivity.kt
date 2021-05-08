package com.example.kotlin_dagger_hilt.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_dagger_hilt.R
import com.example.kotlin_dagger_hilt.domain.GetRetrofitData
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}