package com.example.mrvalipoor.presentation.adapters

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mrvalipoor.R
import com.example.mrvalipoor.data.models.Messages
import com.google.android.material.internal.NavigationMenuItemView

class UsersSupportAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list = arrayListOf<Messages>()

    @JvmName("setList1")
    fun setList(list : ArrayList<Messages>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_support_recview, parent, false)
        val viewHolder = UserSupportViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var supportMe = list.get(position)
        when(holder){
            is UserSupportViewHolder -> holder.setUi(supportMe.getPhone() , supportMe.getDate(), supportMe.getEmail(), supportMe.getMessage())
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class UserSupportViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var phoneNumber = itemView.findViewById<TextView>(R.id.supportPhoneNumber)
        var supportMessage = itemView.findViewById<TextView>(R.id.supportMessageBody)
        var date = itemView.findViewById<TextView>(R.id.supportDateField)
        var constraintLayout = itemView.findViewById<ConstraintLayout>(R.id.supportExpand)
        var email = itemView.findViewById<TextView>(R.id.supportEmailField)

        var isExpandOrNot = false

        var spamClose = itemView.findViewById<TextView>(R.id.supportHide)
        var spamOpen = itemView.findViewById<TextView>(R.id.supportShow)

        var closeImage = itemView.findViewById<ImageButton>(R.id.supportClose)
        var openImage = itemView.findViewById<ImageButton>(R.id.supportOpen)

        fun setUi(phone : String , supportDate : String , userEmail : String, message : String){
            phoneNumber.text = phone
            supportMessage.text = message
            date.text = supportDate
            email.text = userEmail

            setOnClick(openImage , closeImage)

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