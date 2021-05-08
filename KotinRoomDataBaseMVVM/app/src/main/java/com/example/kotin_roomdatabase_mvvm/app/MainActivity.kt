package com.example.kotin_roomdatabase_mvvm.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.kotin_roomdatabase_mvvm.R
import com.example.kotin_roomdatabase_mvvm.app.Manager.Manager

class MainActivity : AppCompatActivity(), Manager.View {

    lateinit var name : EditText
    lateinit var password : EditText

    lateinit var submit : Button

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLayout()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.setContextDataBase(this)
        viewModel.getAllData()

        setOnClick(submit)

    }

    private fun setOnClick(submit: Button) {
        submit.setOnClickListener {
            if (name.text.isNullOrEmpty() || password.text.isNullOrEmpty()) onError("Fields Are Empty")
            else {
                onSuccess("Logged In ...")
                viewModel.isInDataBaseOrNot(name.text.toString(), password.text.toString())
            }
        }
    }

    private fun initLayout() {
        name = findViewById(R.id.name)
        password = findViewById(R.id.pass)
        submit = findViewById(R.id.submit)
    }

    override fun onSuccess(message: String) {
        makeToast(message)
    }

    override fun onError(error: String) {
        makeToast(error)
    }

    fun makeToast(message : String){
        Toast.makeText(this , message , Toast.LENGTH_SHORT).show()
    }
}