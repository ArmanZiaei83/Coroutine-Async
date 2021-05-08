package com.example.mrvalipoor.data.models

class Transaction(jobName: String, jobPhone: String, jobFollowNumber: Long, jobReason: String, jobPrice: String, jobDate: String) {

    var name = jobName
    var phoneNumber = jobPhone
    var jobFollowCode = jobFollowNumber
    var jobProblem = jobReason
    var price = jobPrice
    var date = jobDate

    @JvmName("getName1")
    fun getName() : String {
        return name
    }

    @JvmName("getPhoneNumber1")
    fun getPhoneNumber() : String {
        return phoneNumber
    }

    fun getFollowCode() : Long {
        return jobFollowCode
    }

    @JvmName("getJobProblem1")
    fun getJobProblem() : String {
        return jobProblem
    }

    @JvmName("getPrice1")
    fun getPrice() : String {
        return price
    }

    @JvmName("getDate1")
    fun getDate() : String {
        return date
    }
}