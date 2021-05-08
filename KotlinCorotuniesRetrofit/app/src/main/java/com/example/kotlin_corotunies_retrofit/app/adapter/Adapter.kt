package com.example.kotlin_corotunies_retrofit.app.adapter

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin_corotunies_retrofit.R
import com.example.kotlin_corotunies_retrofit.data.Data

class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var context: Context

    var list = listOf<Data>()

    @JvmName("setList1")
    fun setList(list : List<Data>){
        this.list = list
    }

    @JvmName("setContext1")
    fun setContext(context: Context){
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view , parent , false)
        val viewHodler = MyViewHolder(view)
        return viewHodler
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var data = list.get(position)

        when(holder){
            is MyViewHolder -> holder.setLayout(data , context)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val userView = itemView.findViewById<ImageView>(R.id.userView)
        val name = itemView.findViewById<TextView>(R.id.full_name)
        val email = itemView.findViewById<TextView>(R.id.email)

        fun setLayout(data : Data , context: Context){
            Glide.with(context).load(data.getAvatar()).into(userView)
            name.text = "Name : " + data.getFName() + " " + data.getLName()
            email.text = "Email : " + data.getEmail()
        }

    }

}