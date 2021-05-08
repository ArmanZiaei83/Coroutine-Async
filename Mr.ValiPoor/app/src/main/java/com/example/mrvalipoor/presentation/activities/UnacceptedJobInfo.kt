package com.example.mrvalipoor.presentation.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mrvalipoor.R
import com.example.mrvalipoor.presentation.dialogs.*
import com.example.mrvalipoor.presentation.dialogs.call.CallDialog
import com.example.mrvalipoor.presentation.dialogs.call.CallHistoryDialog
import com.example.mrvalipoor.presentation.dialogs.logo.LogoDialog
import com.example.mrvalipoor.presentation.dialogs.logo.LogoHistoryDialog

class UnacceptedJobInfo : AppCompatActivity(), View.OnClickListener, OnPassData {

    lateinit var constraintLayout: ConstraintLayout
    lateinit var title : TextView
    lateinit var part : TextView
    lateinit var infoState : TextView
    lateinit var phone : TextView
    lateinit var email : TextView

    lateinit var showButton : ImageButton
    lateinit var hideButton : ImageButton

    lateinit var logoHistory : Button
    lateinit var callHistory : Button

    lateinit var setLogoGift : TextView
    lateinit var setCallgift : TextView

    lateinit var isAccepted : Switch
    lateinit var submit : Button
    lateinit var cancel : Button

    lateinit var backToMain : Button

    lateinit var spamClose : TextView
    lateinit var spamOpen : TextView

    var newSituation = false
    var isExpandOrNot = false

    lateinit var logoDialog : LogoDialog
    lateinit var callDialog: CallDialog

    lateinit var callHistoryDialog : CallHistoryDialog
    lateinit var logoHistoryDialog : LogoHistoryDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unaccepted_job_info)

        setNavColor()
        setUi()

        setItemsData()
        setSubmitOnClick()
        setCancelOnClick()
        setOnClick(showButton , hideButton)
        setLogoDialog()
        setInfoCallGift()
        setOnClicks()
    }

    private fun setInfoCallGift() {
        callDialog = CallDialog(this , this)
        setCallgift.setOnClickListener{
            callDialog.create()
            callDialog.show()
            callDialog.setOnPassData(this)
        }

    }

    private fun setLogoDialog() {
        logoDialog = LogoDialog(this , this)
        setLogoGift.setOnClickListener{
            logoDialog.create()
            logoDialog.show()
            logoDialog.setOnPassData(this)
        }

    }

    private fun setCancelOnClick() {
        cancel.setOnClickListener{
            val toJobs = Intent(this , WaitingForAcceptanceJobs::class.java)
            toJobs.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(toJobs)
        }
    }

    private fun setSubmitOnClick() {
        submit.setOnClickListener{
            sendBoolean(newSituation)
        }
    }

    fun setOnClick (open : ImageButton, close : ImageButton){
        open.setOnClickListener{
            isExpandOrNot = true
            spamClose.visibility = View.VISIBLE
            spamOpen.visibility = View.GONE
            open.visibility = View.GONE
            close.visibility = View.VISIBLE
            checkCondition(isExpandOrNot)
        }
        close.setOnClickListener{
            isExpandOrNot = false
            spamOpen.visibility = View.VISIBLE
            spamClose.visibility = View.GONE
            close.visibility = View.GONE
            open.visibility = View.VISIBLE
            checkCondition(isExpandOrNot)
        }
    }

    private fun checkCondition(isExpand: Boolean) {
        if (isExpand){
            constraintLayout.visibility = View.VISIBLE
        }else constraintLayout.visibility = View.GONE
    }

    private fun sendBoolean(newSituation: Boolean) {
        val intent = Intent(this , WaitingForAcceptanceJobs::class.java)
        intent.putExtra("boolean", newSituation)
        startActivity(intent)
    }

    private fun setItemsData() {
        val bundle = intent.extras
        title.text = bundle!!.get("title").toString()
        part.text = part.text.toString() + bundle.get("part").toString()
        infoState.text = infoState.text.toString() + bundle.get("state").toString()
        phone.text = phone.text.toString() + "0" + bundle.get("phone").toString()
        email.text = email.text.toString() + bundle.get("email").toString()
        setSwitchPosition(bundle.get("acceptance") as Boolean)
    }

    private fun setSwitchPosition(boolean : Boolean) {
        isAccepted.isChecked = boolean

        isAccepted.setOnClickListener{
            if(isAccepted.isChecked){
                Toast.makeText(this , "کاربر تایید شد" , Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this , "وضعیت کاربر به تایید نشده تغییر یافت" , Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun setOnClicks() {
        backToMain.setOnClickListener(this)
        logoHistory.setOnClickListener(this)
        callHistory.setOnClickListener(this)
    }

    private fun setUi() {
        constraintLayout = findViewById(R.id.unacceptedInfotConstraintLayout)
        title = findViewById(R.id.unacceptedInfoTitle)
        part = findViewById(R.id.unacceptedInfoPart)
        infoState = findViewById(R.id.unacceptedInfoState)
        phone = findViewById(R.id.unacceptedInfoPhone)
        email = findViewById(R.id.unacceptedInfoEmail)
        showButton = findViewById(R.id.unacceptedInfoShowGift)
        hideButton = findViewById(R.id.unacceptedInfoHideGift)
        logoHistory = findViewById(R.id.unacceptedLogoGiftHistory)
        callHistory = findViewById(R.id.unacceptedfreeCallGiftHistory)
        setLogoGift = findViewById(R.id.unacceptedInfoLogoGift)
        setCallgift = findViewById(R.id.unacceptedInfoCallGift)
        submit = findViewById(R.id.unacceptedSubmit)
        cancel = findViewById(R.id.unacceptedCancel)

        spamClose = findViewById(R.id.unacceptedJobHide)
        spamOpen = findViewById(R.id.unacceptedJobShow)

        isAccepted = findViewById(R.id.unacceptedIsAccepted)
        backToMain = findViewById(R.id.unacceptedInfoBack)

    }

    private fun setNavColor() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        }
    }

    override fun onClick(view: View?) {
        if (view!!.id == backToMain.id || view!!.id == cancel.id) {
            goToMain()
        }
        if(view.id == logoHistory.id){
            logoHistoryDialog = LogoHistoryDialog(this , this)
            logoHistory.setOnClickListener{
                logoHistoryDialog.create()
                logoHistoryDialog.show()
            }
        }
        if(view.id == callHistory.id){
            callHistoryDialog = CallHistoryDialog(this , this)
            callHistory.setOnClickListener{
                callHistoryDialog.create()
                callHistoryDialog.show()
            }
        }
    }

    private fun goToMain() {
        val toMain = Intent(this , WaitingForAcceptanceJobs::class.java)
        startActivity(toMain)
    }

    override fun passLogoGift(string: String) {
        setLogoGift.text = string
    }

    override fun passFreeCallGift(string: String) {
        setCallgift.text = string
    }


}