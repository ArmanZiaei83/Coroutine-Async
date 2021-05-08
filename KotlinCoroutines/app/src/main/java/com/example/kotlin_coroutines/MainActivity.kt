package com.example.kotlin_coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var result : TextView
    lateinit var button : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        button.setOnClickListener({
                CoroutineScope(IO).launch {
                    getFirst()
                }
            }
        )
    }

    private suspend fun getFirst(){
        val result1 = firstResult()
        setToTextView(result1)

        val result2 = secondResult()
        setToTextView(result2)
    }

    private suspend fun setToTextView(result1: String) {
        withContext(Main){
            result.text = "${result.text} -- $result1 \n"
        }
    }

    private suspend fun getSecond(){
        val result2 = secondResult()
        println("Result : $result2")
    }

    private suspend fun firstResult() : String{
        delay(2000)
        return "#First Result"
    }

    private suspend fun secondResult() : String{
        delay(2000)
        return "#Second Result"
    }

    private fun initView() {
        button = findViewById(R.id.button)
        result = findViewById(R.id.resultView)
    }
}