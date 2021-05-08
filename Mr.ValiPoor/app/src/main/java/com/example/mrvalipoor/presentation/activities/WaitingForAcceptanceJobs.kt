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
import com.example.mrvalipoor.presentation.adapters.UnacceptedJobsAdapter

class WaitingForAcceptanceJobs : AppCompatActivity(), SetOnClick{

    lateinit var jobsBackToMain: Button
    lateinit var typeNamePhone: EditText
    lateinit var searchButton: Button
    lateinit var recyclerView: RecyclerView
    lateinit var manager: LinearLayoutManager
    lateinit var adapter: UnacceptedJobsAdapter

    lateinit var jobImageView: ImageView
    lateinit var uri: Uri

    val list = arrayListOf<AcceptedJobDetails>(
        AcceptedJobDetails(
            "سلام",
            "لوازم بهداشتی",
            "09198555555",
            "salam@gmail.com",
            "البرز",
            false
        ),
        AcceptedJobDetails(
            "شون",
            "لوازم بهداشتی",
             "09408555555",
            "shoon@gmail.com",
            "البرز",
            false
        ),
        AcceptedJobDetails(
            "آفتاب",
            "مواد غذایی",
             "09398555555",
            "aftaab@gmail.com",
            "تهران",
            false
        ),
        AcceptedJobDetails(
            "رامک",
            "مواد غذایی",
            "09158555555",
            "ramaak@gmail.com",
            "فارس",
            false
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waiting_for_acceptance_jobs)

        setNavColor()
        setUi()
        setOnClick()
        setSearchResult()
    }

    private fun setSearchResult() {
        typeNamePhone.addTextChangedListener(object : TextWatcher {
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
        var jobList = arrayListOf<AcceptedJobDetails>()
        searchButton.setOnClickListener {
            for (item in list) {
                if (item.getJobTitle().contains(text) || item.jobPhone.toString().contains(text)) {
                    jobList.add(item)
                }
            }
            adapter.setJobList(jobList)
        }
    }

    private fun setOnClick() {
        jobsBackToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent)
        }
    }
    private fun setUi() {
        jobsBackToMain = findViewById(R.id.jobsBack)
        typeNamePhone = findViewById(R.id.searchForWatingJobs)
        searchButton = findViewById(R.id.searchJobs)
        recyclerView = findViewById(R.id.waitingForAcceptanceRecView)
        adapter = UnacceptedJobsAdapter()
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
        var toJobInfo = Intent(this, UnacceptedJobInfo::class.java)

        toJobInfo.putExtra("title", jobs.getJobTitle())
        toJobInfo.putExtra("state", jobs.getJobState())
        toJobInfo.putExtra("part", jobs.getJobPart())
        toJobInfo.putExtra("phone", jobs.getPhone())
        toJobInfo.putExtra("email", jobs.getEmail())
        toJobInfo.putExtra("acceptance", jobs.getJobIsAccepted())
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
