package com.example.mrvalipoor.presentation.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mrvalipoor.R
import com.example.mrvalipoor.data.models.AcceptedJobDetails
import com.example.mrvalipoor.presentation.SetOnClick
import com.example.mrvalipoor.presentation.dialogs.PhotoChangedDialog

class UnacceptedJobsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list = arrayListOf<AcceptedJobDetails>()
    lateinit var activity : Activity

    lateinit var setOnClick: SetOnClick

    fun setOnClick(setOnClick: SetOnClick){
        this.setOnClick = setOnClick
    }

    @JvmName("setActivity1")
    fun setActivity(activity: Activity){
        this.activity = activity
    }

    fun setJobList(list : ArrayList<AcceptedJobDetails>) {
        this.list  = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.unaccepted_jobs , parent , false)
        val myViewHolder = UnAccepterJobsViewHolder(view)
        return myViewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var job = list.get(position)

        when(holder){
            is UnAccepterJobsViewHolder -> holder.setUi(job, activity, setOnClick)
        }
    }

    override fun getItemCount(): Int {
        return list.size

    }

    class UnAccepterJobsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var isExpandOrNot = false
        val openImage = itemView.findViewById<ImageButton>(R.id.unacceptedShowImage)
        val closeImage = itemView.findViewById<ImageButton>(R.id.unacceptedCloseImage)
        val jobTitle = itemView.findViewById<TextView>(R.id.unacceptedJobTitle)
        val constraintLay = itemView.findViewById<ConstraintLayout>(R.id.unacceptedExpandAbleImage)
        var jobImage = itemView.findViewById<ImageView>(R.id.unacceptedJobImage)
        val chanageLogo = itemView.findViewById<Button>(R.id.unacceptedChangeLogo)
        val showInfo = itemView.findViewById<Button>(R.id.unacceptedInfo)

        val spamShow = itemView.findViewById<TextView>(R.id.unacceptedjobsShow)
        val spamHide = itemView.findViewById<TextView>(R.id.unacceptedjobsHide)

        lateinit var setOnClick: SetOnClick

        lateinit var jobs : AcceptedJobDetails


        fun setUi(
            job: AcceptedJobDetails,
            activity: Activity,
            setOnClick: SetOnClick,
        ){
            jobs = job
            jobTitle.text = jobs.getJobTitle()
            setOnClick(openImage , closeImage)
            setChangeLogoOnClick(chanageLogo  , activity)

            this.setOnClick = setOnClick
            setJobImageOnClick()
            setInfoOnClick()
        }

        private fun setInfoOnClick() {
            showInfo.setOnClickListener{
                setOnClick.openInfoDetail(jobs)
            }
        }


        private fun setJobImageOnClick() {
            jobImage.setOnClickListener{
                setOnClick.onClick(jobImage)
            }
        }


        private fun setChangeLogoOnClick(logo: Button, activity: Activity) {
            logo.setOnClickListener{
                val myDialog = PhotoChangedDialog(activity)
                myDialog.create()
                myDialog.show()
            }
        }

        fun setOnClick (open : ImageButton, close : ImageButton){
            open.setOnClickListener{
                isExpandOrNot = true
                spamShow.visibility = View.GONE
                spamHide.visibility = View.VISIBLE
                open.visibility = View.GONE
                close.visibility = View.VISIBLE
                checkCondition(isExpandOrNot)
            }
            close.setOnClickListener{
                isExpandOrNot = false
                spamShow.visibility = View.VISIBLE
                spamHide.visibility = View.GONE
                close.visibility = View.GONE
                open.visibility = View.VISIBLE
                checkCondition(isExpandOrNot)
            }
        }

        private fun checkCondition(isExpand: Boolean) {
            if (isExpand){
                constraintLay.visibility = View.VISIBLE
            }else constraintLay.visibility = View.GONE
        }
    }
}