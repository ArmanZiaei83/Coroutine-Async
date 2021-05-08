package com.example.mrvalipoor.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mrvalipoor.R
import com.example.mrvalipoor.presentation.dialogs.tariff.*

class Tariffs : AppCompatActivity(), OnTariffPassData {

    lateinit var tariffNormalFreeCall : TextView
    lateinit var tariffFreePhoneCall2 : TextView
    lateinit var updateLogoInFreeCall : TextView
    lateinit var tariffLogoInNormalCall : TextView
    lateinit var tariffLogoInBrands : TextView
    lateinit var tariffLogoInRec : TextView

    lateinit var backToMain : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tariffs)

        setUi()
        setOnClicks()

    }

    private fun setOnClicks() {

        val callDialog = NormalPhoneCallDialog(this , this)
        val sabetCallDialog = FreePhoneCall(this , this)
        val updateLogoInFreeCalls = UpdateLogoInFreeCall(this , this)
        val updateLogoInNormalCalls = UpdateLogoInNormalCall(this , this)
        val defineLogoInBrands = DefineLogoInBrands(this , this)
        val defineLogoInRec = UpdateLogoFromRec(this , this)

        tariffNormalFreeCall.setOnClickListener{
            callDialog.create()
            callDialog.show()
            callDialog.setOnPassData(this)
        }
        tariffFreePhoneCall2.setOnClickListener{
            sabetCallDialog.create()
            sabetCallDialog.show()
            sabetCallDialog.setOnPassData(this)
        }
        updateLogoInFreeCall.setOnClickListener{
            updateLogoInFreeCalls.create()
            updateLogoInFreeCalls.show()
            updateLogoInFreeCalls.setOnPassData(this)
        }
        tariffLogoInNormalCall.setOnClickListener{
            updateLogoInNormalCalls.create()
            updateLogoInNormalCalls.show()
            updateLogoInNormalCalls.setOnPassData(this)
        }

        tariffLogoInBrands.setOnClickListener{
            defineLogoInBrands.create()
            defineLogoInBrands.show()
            defineLogoInBrands.setOnPassData(this)
        }
        tariffLogoInRec.setOnClickListener{
            defineLogoInRec.create()
            defineLogoInRec.show()
            defineLogoInRec.setOnPassData(this)
        }

        backToMain.setOnClickListener{
            val toMain = Intent(this , MainActivity::class.java)
            toMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(toMain)
        }
    }

    private fun setUi() {
        tariffNormalFreeCall = findViewById(R.id.tariffNormalFreeCall)
        tariffFreePhoneCall2 = findViewById(R.id.tariffFreePhoneCall2)

        updateLogoInFreeCall = findViewById(R.id.updateLogoInFreeCall)
        tariffLogoInNormalCall = findViewById(R.id.tariffLogoInNormalCall)

        tariffLogoInBrands = findViewById(R.id.tariffLogoInBrands)
        tariffLogoInRec = findViewById(R.id.tariffLogoInRec)

        backToMain = findViewById(R.id.tariffBackToMain)

    }

    override fun passNormalCallPrice(data : String) {
        tariffNormalFreeCall.text = data
    }

    override fun passSabetCallPrice(data : String) {
        tariffFreePhoneCall2.text = data
    }

    override fun updateLogoInFreeCall(data : String) {
        updateLogoInFreeCall.text = data
    }

    override fun defineLogoInNormalCall(data : String) {
        tariffLogoInNormalCall.text = data
    }

    override fun defineLogoInBrands(data : String) {
        tariffLogoInBrands.text = data
    }

    override fun defineLogoInRec(data : String) {
        tariffLogoInRec.text = data
    }

}