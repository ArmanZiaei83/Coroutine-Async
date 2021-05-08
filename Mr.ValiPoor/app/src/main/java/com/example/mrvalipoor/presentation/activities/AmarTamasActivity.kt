package com.example.mrvalipoor.presentation.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mrvalipoor.R
import com.example.mrvalipoor.presentation.Manager

class AmarTamasActivity : AppCompatActivity(), Manager.AmarTamasView {

    lateinit var toDayFreeCalls : TextView
    lateinit var toDayNormalCalls : TextView
    lateinit var thisMonthFreeCalls : TextView
    lateinit var thisMonthNormalCalls : TextView

    lateinit var backToMainPage : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amar_tamas)

        setNavColor()
        setUi()
        setOnClick()
    }

    private fun setNavColor() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        }
    }

    override fun setUi() {
        toDayFreeCalls = findViewById(R.id.todayFreeCalls)
        toDayNormalCalls = findViewById(R.id.todayNormalCalls)
        thisMonthFreeCalls = findViewById(R.id.thisMonthFreeCalls)
        thisMonthNormalCalls = findViewById(R.id.thisMonthNormalCalls)
        backToMainPage = findViewById(R.id.backToMain)
    }

    override fun setOnClick() {
        backToMainPage.setOnClickListener{
            val intent = Intent(this , MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent)
        }
    }

    private fun setTextToViews(todayFreeCalls : String, todayNormalCalls : String,
                               monthFreeCalls : String, monthNormalCalls: String ) {
            toDayNormalCalls.text = todayNormalCalls
            toDayFreeCalls.text = todayFreeCalls
            thisMonthNormalCalls.text = monthNormalCalls
            thisMonthFreeCalls.text = monthFreeCalls

    }
}