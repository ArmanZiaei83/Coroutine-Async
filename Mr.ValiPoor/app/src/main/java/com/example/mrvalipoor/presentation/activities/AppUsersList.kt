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
import com.example.mrvalipoor.data.models.UserDetails
import com.example.mrvalipoor.presentation.adapters.UsersAdapter

class AppUsersList : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var manager : LinearLayoutManager
    lateinit var adapter : UsersAdapter

    //SearchUi :
    lateinit var number : EditText
    lateinit var searchButton : Button
    lateinit var backToMain : Button

    var users = arrayListOf<UserDetails>(
        UserDetails("البرز" , "کرج" , "عظیمیه" , "09378777777") ,
        UserDetails("فارس" , "شیراز" , "هوابرد" , "09387888888"),
        UserDetails("تهران" , "تهران" , "شهید رجایی" , "09389777777"),
        UserDetails("فارس" , "فسا" , "مرکزی" , "09398999999"),
        UserDetails("تهران" , "تهران" , "یوسف آباد" , "09305666666"),
        UserDetails("فارس" , "شیراز" , "سعدی" , "09178777777")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_users_list)


        setNavColor()
        setUi()
        numberOnTextChange()

        backToMain.setOnClickListener{
            val toMain = Intent(this , MainActivity::class.java)
            toMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(toMain)
        }
    }

    private fun setNavColor() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        }
    }

    private fun numberOnTextChange() {
        number.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(edit: Editable?) {
                filter(edit.toString())
            }

        })
    }

    private fun filter(keyWord: String) {
        var list = ArrayList<UserDetails>()
        searchButton.setOnClickListener{
            for (userDetail in users){
                if (userDetail.getUserPhoneNumber().toString().contains(keyWord)){
                    list.add(userDetail)
                }
            }
            adapter.setList(list)
        }

    }

    private fun setUi() {
        backToMain = findViewById(R.id.backToMain)
        recyclerView = findViewById(R.id.recyclerView)
        number = findViewById(R.id.userPhoneSearch)
        searchButton = findViewById(R.id.searchButton)
        manager = LinearLayoutManager(this)
        adapter = UsersAdapter()
        adapter.setList(returnList())
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }

    fun returnList() : ArrayList<UserDetails> {
        return users
    }
}