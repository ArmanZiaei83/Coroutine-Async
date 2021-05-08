package com.example.mrvalipoor.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mrvalipoor.R
import com.example.mrvalipoor.data.models.TestHistory

class LogoHistoryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list = arrayListOf<TestHistory>()

    @JvmName("setList1")
    fun setList(list : ArrayList<TestHistory>){
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.logohistory_recview, parent , false)
        var logoHolder  = LogoHolder(view)
        return logoHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var testHistory = list.get(position)
        when(holder){
            is LogoHolder -> holder.setUi(testHistory.getPrice().toString() , testHistory.getDate())
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class LogoHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var price : TextView = itemView.findViewById(R.id.price)
        var date : TextView = itemView.findViewById(R.id.date)

        fun setUi(giftPrice : String , giftDate : String){
            price.text = giftPrice
            date.text = giftDate
        }
    }
}