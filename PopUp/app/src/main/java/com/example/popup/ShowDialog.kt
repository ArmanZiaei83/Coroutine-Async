package com.example.popup

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button

class ShowDialog : android.view.View.OnClickListener , Dialog {

    lateinit var activity: Activity
    lateinit var dialog: Dialog
    lateinit var okButton : Button

    constructor(activity: Activity) : super(activity) {
        this.activity = activity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_layout);

        okButton = findViewById(R.id.okButton)
        okButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when(view.id){
                R.id.okButton -> dismiss()
            }
        }
    }
}