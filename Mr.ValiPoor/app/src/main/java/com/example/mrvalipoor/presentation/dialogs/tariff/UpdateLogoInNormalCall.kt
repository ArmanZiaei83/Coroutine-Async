package com.example.mrvalipoor.presentation.dialogs.tariff

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mrvalipoor.R

class UpdateLogoInNormalCall: Dialog {

    lateinit var activity: Activity
    lateinit var inputNumber : EditText
    lateinit var submit : Button
    lateinit var activityContext : Context
    lateinit var passString : OnTariffPassData

    constructor(activity: Activity, context: Context) : super(activity) {
        this.activity = activity
        this.activityContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.update_logo_in_noraml_call);

        inputNumber = findViewById(R.id.updateNormalCallLogo)
        submit = findViewById(R.id.submitUpdate)

        checkInput()
    }

    private fun checkInput() {
        submit.setOnClickListener{
            if (inputNumber.text.toString().isNullOrEmpty()){
                Toast.makeText(activityContext , "قیمتی تایین نشد" , Toast.LENGTH_SHORT).show()
            }
            else {
                passString.defineLogoInNormalCall(inputNumber.text.toString())
                dismiss()
            }
        }
    }


    fun setOnPassData(onTariffPassData : OnTariffPassData){
        passString  = onTariffPassData
    }
}
