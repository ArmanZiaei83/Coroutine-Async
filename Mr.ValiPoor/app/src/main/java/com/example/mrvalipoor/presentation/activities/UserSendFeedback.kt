package com.example.mrvalipoor.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mrvalipoor.R
import com.example.mrvalipoor.data.models.UserFeedback
import com.example.mrvalipoor.presentation.adapters.FeedbackAdapter

class UserSendFeedback : AppCompatActivity() {

    lateinit var backToMain : Button
    lateinit var input : EditText
    lateinit var searchButton : Button
    lateinit var recyclerView: RecyclerView
    lateinit var manager: LinearLayoutManager
    lateinit var adapter : FeedbackAdapter

    val testList = arrayListOf<UserFeedback>(
        UserFeedback("09174333333" , "محتوای نامناسب" , "1400/7/7" , "feedback@gmail.com"),
        UserFeedback("0970445463" , "محتوای نامناسب" , "1399/12/7", "feedback@gmail.com"),
        UserFeedback("09804333333" , "محتوای نامناسب" , "1399/7/18" , "feedback@gmail.com"),
        UserFeedback("09394333333" , "محتوای نامناسب" , "1399/7/18" , "feedback@gmail.com")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_send_feedback)

        setUi()
        setMainLogic()
    }

    private fun setMainLogic() {
        input.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(text: Editable?) {
                filter(text.toString())
            }
        })

        backToMain.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent)
        }
    }

    private fun filter(text: String) {
        var newList = ArrayList<UserFeedback>()
        searchButton.setOnClickListener{
            for (item in testList){
                if (item.getPhoneNumber().contains(text)){
                    newList.add(item)
                }
            }
            adapter.setList(newList)
        }

    }

    private fun setUi() {
        backToMain = findViewById(R.id.feedbackBackToMain)
        input = findViewById(R.id.feedbackSearchInput)
        searchButton = findViewById(R.id.feedbackSearchButton)

        recyclerView = findViewById(R.id.feedbackRecView)
        manager = LinearLayoutManager(this)
        adapter = FeedbackAdapter()
        adapter.setList(testList)

        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter

    }
}