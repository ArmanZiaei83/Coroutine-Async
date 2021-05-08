package com.example.hideview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var numbers : TextView
    lateinit var hideState : TextView
    lateinit var hideCity : TextView
    lateinit var hideNeighbor : TextView

    lateinit var open : Button
    lateinit var closeUserAccess : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          
    }
}
