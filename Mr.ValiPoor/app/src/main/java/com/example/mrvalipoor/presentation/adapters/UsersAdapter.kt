package com.example.mrvalipoor.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mrvalipoor.R
import com.example.mrvalipoor.data.models.UserDetails
import kotlin.collections.ArrayList

class UsersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var users = arrayListOf<UserDetails>()

    fun setList (list : ArrayList<UserDetails>){
        this.users = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_users , parent , false)
        val viewHolder = MyViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var userDetails = users.get(position)
        when(holder){
            is MyViewHolder -> holder.setUi(userDetails.userState , userDetails.userCity ,
                userDetails.userNeighbor , userDetails.userPhoneNumber)
        }
    }


    override fun getItemCount(): Int {
        return users.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val numberView = itemView.findViewById<TextView>(R.id.userTitle)
        val state = itemView.findViewById<TextView>(R.id.state)
        val city = itemView.findViewById<TextView>(R.id.city)
        val neighbor = itemView.findViewById<TextView>(R.id.neighbor)

        val expandButton = itemView.findViewById<ImageButton>(R.id.expandButton)
        val closeButton = itemView.findViewById<ImageButton>(R.id.closeButton)
        val bandUser = itemView.findViewById<Button>(R.id.bandUser)

        val constraintLayout = itemView.findViewById<ConstraintLayout>(R.id.expandAble)

        var isExpandOrNot = false

        var spamClose = itemView.findViewById<TextView>(R.id.usersHide)
        var spamOpen = itemView.findViewById<TextView>(R.id.usersShow)

        fun setUi(
            userState: String,
            userCity: String,
            userNeighbor: String,
            userPhoneNumber: String,
        ) {
            numberView.text = userPhoneNumber
            state.text = "استان: $userState"
            city.text = "شهر: $userCity"
            neighbor.text =  "محله: $userNeighbor"

            setOnClick(expandButton , closeButton)
        }

        private fun checkCondition(isExpand: Boolean) {
            if (isExpand){
                constraintLayout.visibility = View.VISIBLE
            }else constraintLayout.visibility = View.GONE
        }

        fun setOnClick (open : ImageButton, close : ImageButton){
            open.setOnClickListener{
                isExpandOrNot = true
                open.visibility = View.GONE
                spamOpen.visibility = View.GONE
                spamClose.visibility = View.VISIBLE
                close.visibility = View.VISIBLE
                checkCondition(isExpandOrNot)
            }
            close.setOnClickListener{
                isExpandOrNot = false
                close.visibility = View.GONE
                spamOpen.visibility = View.VISIBLE
                spamClose.visibility = View.GONE
                open.visibility = View.VISIBLE
                checkCondition(isExpandOrNot)
            }
        }
    }


}
