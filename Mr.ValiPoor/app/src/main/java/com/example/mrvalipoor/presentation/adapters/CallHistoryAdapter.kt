package com.example.mrvalipoor.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mrvalipoor.R
import com.example.mrvalipoor.data.models.TestHistory

class CallHistoryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list = arrayListOf<TestHistory>()

    @JvmName("setList1")
    fun setList(list: ArrayList<TestHistory>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.callhistory_recview, parent, false)
        var callHolder = CallViewHolder(view)
        return callHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var testHistory = list.get(position)
        when (holder) {
            is CallViewHolder -> holder.setUi(
                testHistory.getPrice().toString(),
                testHistory.getDate()
            )
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class CallViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var price = itemView.findViewById<TextView>(R.id.callPrice)
        var date = itemView.findViewById<TextView>(R.id.callDate)

        fun setUi(callPrice: String, callDate: String) {
            price.text = callPrice
            date.text = callDate
        }
    }
}