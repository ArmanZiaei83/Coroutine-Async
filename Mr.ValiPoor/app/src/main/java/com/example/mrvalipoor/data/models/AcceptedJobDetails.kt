package com.example.mrvalipoor.data.models

class AcceptedJobDetails(title: String, part: String, phone: String, email: String, state: String, isAccepted: Boolean) {

    var jobTitle = title
    var jobPart = part
    var jobPhone = phone
    var jobEmail = email
    var jobState = state
    var jobIsAccepted = isAccepted

    @JvmName("getJobIsAccepted1")
    fun getJobIsAccepted() : Boolean {
        return jobIsAccepted
    }

    fun setBoolean(boolean: Boolean) {
        this.jobIsAccepted = boolean
    }

    @JvmName("getJobTitle1")
    fun getJobTitle() : String{
        return jobTitle
    }

    @JvmName("getJobState1")
    fun getJobState(): String {
        return jobState
    }

    @JvmName("getJobPart1")
    fun getJobPart(): String {
        return jobPart
    }

    fun getPhone(): String {
        return jobPhone
    }

    fun getEmail(): String {
        return jobEmail
    }

}