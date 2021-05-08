package com.example.mrvalipoor.presentation.activities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mrvalipoor.R
import com.example.mrvalipoor.data.models.AcceptedJobDetails
import com.example.mrvalipoor.presentation.SetOnClick
import com.example.mrvalipoor.presentation.adapters.AcceptJobsAdapter

class AcceptJobs : AppCompatActivity(), SetOnClick {

    lateinit var backButton : Button
    lateinit var typeNamePhone : EditText
    lateinit var searchButton: Button
    lateinit var recyclerView: RecyclerView
    lateinit var manager : LinearLayoutManager
    lateinit var adapter : AcceptJobsAdapter

    lateinit var jobImageView: ImageView
    lateinit var uri : Uri

    val list = arrayListOf<AcceptedJobDetails>(
        AcceptedJobDetails("سلام" , "مواد غذایی" , "09198555555" , "salam@gmail.com" , "البرز", false),
        AcceptedJobDetails("فیروز" , "لوازم بهداشتی" , "09408555555" , "firooz@gmail.com" , "البرز", true),
        AcceptedJobDetails("محصولات ارگانیک پارس" , "مواد غذایی" , "09398555555" , "pars@gmail.com" , "تهران", true),
        AcceptedJobDetails("پگاه" , "مواد غذایی" ,"09158555555" , "pegah@gmail.com" , "فارس", false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accept_jobs)

        setNavColor()
        setUi()
        setbackButton()
        setSearchResult()
    }

    private fun setSearchResult() {
        typeNamePhone.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(text: Editable?) {
                filter(text.toString())
            }
        })
    }

    private fun filter(text: String) {
        var jobList = ArrayList<AcceptedJobDetails>()
        searchButton.setOnClickListener{
            for (item in list){
                if(item.getJobTitle().contains(text) || item.jobPhone.contains(text)){
                    jobList.add(item)
                }
            }
            adapter.setJobList(jobList)
        }
    }

    private fun setbackButton() {
        backButton.setOnClickListener{
            val intent = Intent(this , MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent)
        }
    }

    private fun setUi() {
        backButton = findViewById(R.id.backButton)
        typeNamePhone = findViewById(R.id.searchForWatingJobs)
        searchButton = findViewById(R.id.searchResults)
        recyclerView = findViewById(R.id.accpetedJobsRecyclerView)
        adapter = AcceptJobsAdapter()
        adapter.setJobList(list)
        adapter.setActivity(this)
        adapter.setOnClick(this)
        manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }

    private fun setNavColor() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        }
    }

    companion object {
        const val REQUEST_IMAGE_GET = 1
    }

    override fun onClick(image: ImageView) {
        jobImageView = image
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "image/*"
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET)
        }
    }

    override fun openInfoDetail(jobs: AcceptedJobDetails) {
        var toJobInfo = Intent(this , JobInfo::class.java)

        toJobInfo.putExtra("title" , jobs.getJobTitle())
        toJobInfo.putExtra("state" , jobs.getJobState())
        toJobInfo.putExtra("part" , jobs.getJobPart())
        toJobInfo.putExtra("phone" , jobs.getPhone())
        toJobInfo.putExtra("email" , jobs.getEmail())
        toJobInfo.putExtra("acceptance" , jobs.getJobIsAccepted())
        startActivity(toJobInfo)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_GET && resultCode == Activity.RESULT_OK) {
            val fullPhotoUri: Uri = data!!.data!!
            jobImageView.setImageURI(fullPhotoUri)
        }
    }
}