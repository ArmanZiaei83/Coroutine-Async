package com.example.mrvalipoor.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mrvalipoor.R
import com.example.mrvalipoor.data.models.UserFeedback

class FeedbackAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list = arrayListOf<UserFeedback>()

    @JvmName("setList1")
    fun setList(list : ArrayList<UserFeedback>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feedback_recview, parent, false)
        val viewHolder = FeedbackViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var feedback = list.get(position)

        when(holder){
            is FeedbackViewHolder -> holder.setUi(feedback.getPhoneNumber() , feedback.getFTitle(), feedback.getEmail(), feedback.getDate())
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class FeedbackViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var phoneNumber = itemView.findViewById<TextView>(R.id.feedbackPhoneNumber)
        var phoneField = itemView.findViewById<TextView>(R.id.feedbackPhoneNumberField)
        var title = itemView.findViewById<TextView>(R.id.feedbackTitleField)
        var email = itemView.findViewById<TextView>(R.id.feedbackEmailField)
        var feedbackDate = itemView.findViewById<TextView>(R.id.feedbackDateField)

        var closeButton = itemView.findViewById<ImageButton>(R.id.feedbackClose)
        var openButton = itemView.findViewById<ImageButton>(R.id.feedbackOpen)

        var spamClose = itemView.findViewById<TextView>(R.id.feedbackHide)
        var spamOpen = itemView.findViewById<TextView>(R.id.feedbackShow)

        var constraintLayout = itemView.findViewById<ConstraintLayout>(R.id.feedbackExpand)
        var isExpandOrNot = false

        fun setUi(phone : String, fTitle : String, fEmail : String, date : String) {
            phoneNumber.text = phone
            phoneField.text = phone
            title.text = fTitle
            email.text = fEmail
            feedbackDate.text = date

            setOnClick(openButton , closeButton)
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