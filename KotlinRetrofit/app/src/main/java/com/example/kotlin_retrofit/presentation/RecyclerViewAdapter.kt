package com.example.kotlin_retrofit.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_retrofit.R
import com.example.kotlin_retrofit.data.entity.RetModel
import com.example.kotlin_retrofit.presentation.RecyclerViewAdapter.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var retModels : List<RetModel> = ArrayList()

    fun setList(list : List<RetModel>) {
        retModels = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rec_view , parent , false)
        val viewHolder = MyViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MyViewHolder -> holder.setLayoutWidgets(retModels.get(position))
        }
    }

    override fun getItemCount(): Int {
        return retModels.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.dataTitle)
        val body = itemView.findViewById<TextView>(R.id.dataBody)

        fun setLayoutWidgets(model : RetModel){
            title.setText("Post Title : " + model.getDataTitle())
            body.setText("Psot Body : " + model.getDataBody())
        }
    }

}

