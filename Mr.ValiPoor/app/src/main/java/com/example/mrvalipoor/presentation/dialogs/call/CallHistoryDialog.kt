package com.example.mrvalipoor.presentation.dialogs.call

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mrvalipoor.R
import com.example.mrvalipoor.data.models.TestHistory
import com.example.mrvalipoor.presentation.adapters.CallHistoryAdapter
import com.example.mrvalipoor.presentation.dialogs.OnPassData

class CallHistoryDialog: Dialog {

    lateinit var activity: Activity
    lateinit var submit : Button
    lateinit var activityContext : Context

    lateinit var recyclerView: RecyclerView
    lateinit var manager: LinearLayoutManager
    lateinit var callAdapter : CallHistoryAdapter

    lateinit var passString : OnPassData

    val myList = arrayListOf<TestHistory>(
        TestHistory(50000 , "1399/10/3"),
        TestHistory(200000 , "1399/10/4"),
        TestHistory(15000 , "1399/10/12"),
        TestHistory(60000 , "1399/10/27")
    )

    constructor(activity: Activity, context: Context) : super(activity) {
        this.activity = activity
        this.activityContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.call_history_dialog);

        submit = findViewById(R.id.callHistorySubmit)
        recyclerView = findViewById(R.id.callRec)
        manager = LinearLayoutManager(context)
        callAdapter = CallHistoryAdapter()
        callAdapter.setList(myList)

        recyclerView.layoutManager = manager
        recyclerView.adapter = callAdapter

        checkInput()
    }

    private fun checkInput() {
        submit.setOnClickListener{
            dismiss()
        }
    }
}