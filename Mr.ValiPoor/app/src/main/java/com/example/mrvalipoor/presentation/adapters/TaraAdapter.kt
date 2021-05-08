package com.example.mrvalipoor.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.solver.state.State
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mrvalipoor.R
import com.example.mrvalipoor.data.models.Transaction

class TaraAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var jobsList = arrayListOf<Transaction>()

    fun setList (list : ArrayList<Transaction>){
        this.jobsList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tara_recycler_view, parent , false)
        var viewHolder = TaraViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var tra = jobsList.get(position)

        when(holder){
            is TaraViewHolder -> holder.setUi(tra.getPhoneNumber().toString() , tra.getName() , tra.getFollowCode().toString() , tra.getJobProblem() , tra.getPrice() , tra.getDate())
        }
    }

    override fun getItemCount(): Int {
        return jobsList.size
    }

    class TaraViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var jobName = itemView.findViewById<TextView>(R.id.traShowJobName)
        var followNumber = itemView.findViewById<TextView>(R.id.traShowJobFollowNumber)
        var traReason = itemView.findViewById<TextView>(R.id.traShowReason)
        var traPrice = itemView.findViewById<TextView>(R.id.traShowPrice)
        var traDate = itemView.findViewById<TextView>(R.id.traShowDate)
        var jobPhoneNumber = itemView.findViewById<TextView>(R.id.traPhoneNumber)
        var constraintLayout = itemView.findViewById<ConstraintLayout>(R.id.traExpand)

        var isExpandOrNot = false

        var spamClose = itemView.findViewById<TextView>(R.id.traSpamHide)
        var spamOpen = itemView.findViewById<TextView>(R.id.traSpamShow)

        var closeImage = itemView.findViewById<ImageButton>(R.id.traClose)
        var openImage = itemView.findViewById<ImageButton>(R.id.traOpen)

        fun setUi(getPhoneNumber: String, name: String, followCode: String, jobProblem: String, price: String, date: String) {
            jobName.text = name
            followNumber.text = followCode
            traReason.text = jobProblem
            traPrice.text = price
            traDate.text = date
            jobPhoneNumber.text = getPhoneNumber

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