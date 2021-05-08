package com.example.coroutine_async

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    //UI:
    lateinit var textView : TextView
    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUI()
        button.setOnClickListener{
            CoroutineScope(IO).launch {
                getResults()
            }
        }
    }

    private fun setUI() {
        textView = findViewById(R.id.resultView)
        button = findViewById(R.id.clickMe)
    }

    private suspend fun getResults () {
        CoroutineScope(IO).launch {
            val results = measureTimeMillis {

                val result1 : Deferred<String> = async {
                    println("Getting Result One>>")
                    getFResult()
                 }

                val result2 : Deferred<String> = async {
                    println("Getting Result Two>>")
                    getSResult()
                }

                setText(result1.await())
                setText(result2.await())
            }
        }
    }

    private fun getFResult() : String {
        return "<<First Result>>"
    }

    private fun getSResult() : String {
        return "<<Second Result>>"
    }

    private fun setText (text : String) {
        CoroutineScope(Main).launch {
            textView.text = textView.text.toString() + "\n" + text
        }
    }
}