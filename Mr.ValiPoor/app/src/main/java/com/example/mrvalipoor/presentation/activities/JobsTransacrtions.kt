package com.example.mrvalipoor.presentation.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mrvalipoor.R
import com.example.mrvalipoor.data.models.Transaction
import com.example.mrvalipoor.presentation.adapters.TaraAdapter

class JobTransactions : AppCompatActivity() {

    //Main Widgets :
    lateinit var backToMain : Button
    lateinit var searchButton : Button
    lateinit var searchInput : EditText

    //RecyclerView:
    lateinit var recyclerView : RecyclerView
    lateinit var manager : LinearLayoutManager
    lateinit var adapter : TaraAdapter

    //Sample List :

    val list = arrayListOf<Transaction>(
            Transaction("محصولات ارگانیک پارس" , "09178777777" , 22434444888 , "تماس رایگان به تلفن ثابت" , "75/000" , "1400/8/29"),
            Transaction("فیروز" , "09390700000" , 2243674888, "ارتقاء لوگوی برند در ردیف برندها" , "50/000" , "1400/8/29"),
            Transaction("پگاه" , "09104888888" , 2243444866 , "ارتقاء لوگو در ردیف پیشنهاد شده ها" , "16/000" , "1400/8/29"),
            Transaction("رامک" , "09807666666" , 2243444800 , "ارتقاء لوگوی برند در ردیف برندها" , "20/000" , "1400/8/29"),
            Transaction("شون" , "09807666666" , 2243444887 , "ارتقاء لوگو در ردیف پیشنهاد شده ها" , "80/000" , "1400/8/29")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jobs_transacrtions)

        setNavColor()
        setUi()
        setOnClicks()
        setInputLogic()
    }

    private fun setOnClicks() {
        //back Button:
        backToMain.setOnClickListener{
            val toMain = Intent(this, MainActivity::class.java)
            toMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(toMain)
        }
    }

    private fun setNavColor() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        }
    }

    private fun setInputLogic() {
        searchInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(input: Editable?) {
                filter(input.toString())
            }

        })
    }

    private fun filter(input: String) {
        var newList = ArrayList<Transaction>()

        searchButton.setOnClickListener{
            for (item in list){
                if (item.getName().contains(input) || item.getPhoneNumber().toString().contains(input)){
                    newList.add(item)
                }
            }
            adapter.setList(newList)
        }
    }

    private fun setUi() {
        backToMain = findViewById(R.id.traBackToMain)
        searchButton = findViewById(R.id.traSearch)
        searchInput = findViewById(R.id.traSearchField)
        recyclerView = findViewById(R.id.traRecView)
        manager = LinearLayoutManager(this)
        adapter = TaraAdapter()
        adapter.setList(list)

        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }
}