package com.example.mrvalipoor.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mrvalipoor.R
import com.example.mrvalipoor.data.models.Messages
import com.example.mrvalipoor.presentation.adapters.UsersSupportAdapter

class UserSupport : AppCompatActivity() {

    lateinit var backToMain : Button
    lateinit var searchInput : EditText
    lateinit var searchButton : TextView
    lateinit var recyclerView : RecyclerView
    lateinit var manager : LinearLayoutManager
    lateinit var adapter : UsersSupportAdapter

    val testList = arrayListOf<Messages>(
        Messages("1400/2/12"  , "مشکل در بالا آمدن برنامه" , "user1@gmail.com" , "09398333333" ),
        Messages("1399/6/2"  , "مشکل در پرداخت وجه" , "user2@gmail.com" , "09178333333" ),
        Messages("1399/1/12"  , "یک مشکل ارتباطی" , "user3@gmail.com" , "09778333333" ),
        Messages("1399/2/20"  , "خطا در اتصال به سرور" , "user4@gmail.com" , "09708333333" ),
        Messages("1398/11/14"  , "مشکل در بالا آمدن برنامه" , "user5@gmail.com" , "09408333333" )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_support)

        setUi()
        setOnClicks()
    }

    private fun setOnClicks() {
        backToMain.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent)
        }
        searchInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(text: Editable?) {
                filter(text.toString())
            }

        })
    }

    private fun filter(text: String) {
        var newList = ArrayList<Messages>()
        searchButton.setOnClickListener{
            for (item in testList){
                if (item.getPhone().contains(text)){
                    newList.add(item)
                }
            }
        }
        adapter.setList(newList)
    }

    private fun setUi() {
        backToMain = findViewById(R.id.supportBackToMain)
        searchInput = findViewById(R.id.supportSearchInput)
        searchButton = findViewById(R.id.supportSearchButton)
        recyclerView = findViewById(R.id.supportRecView)
        manager = LinearLayoutManager(this)
        adapter = UsersSupportAdapter()
        adapter.setList(testList)

        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }
}