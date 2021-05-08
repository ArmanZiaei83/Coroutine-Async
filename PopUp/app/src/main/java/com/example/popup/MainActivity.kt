package com.example.popup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var popUp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUi()

        popUp.setOnClickListener{
            startPopupWindow()
        }
    }

    private fun startPopupWindow() {
        val myDialog = ShowDialog(this)
        myDialog.create()
        myDialog.show()
    }

    private fun setUi() {
        popUp = findViewById(R.id.pop)
    }
}