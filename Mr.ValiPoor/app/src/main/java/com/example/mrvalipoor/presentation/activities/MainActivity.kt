package com.example.mrvalipoor.presentation.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.mrvalipoor.R
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    lateinit var amarTamas : Button
    lateinit var usersList : Button
    lateinit var acceptedJobs : Button
    lateinit var waitigForAcceptJobs : Button
    lateinit var settingPrices : Button
    lateinit var workTara : Button
    lateinit var usersFeedbacks : Button
    lateinit var usersSupport : Button
    lateinit var defineState : Button
    lateinit var defineCity : Button
    lateinit var defineNeghbothood : Button
    lateinit var defineJobs : Button
    lateinit var defineNaghsh : Button
    lateinit var teammates : Button
    lateinit var defineSearchParts : Button
    lateinit var defineSearchBrands : Button
    lateinit var defineSearchGroups : Button
    lateinit var defineSearchDasteha : Button
    lateinit var defineSearchProductsAndServices : Button

    lateinit var exit : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setNavColor()
        setUi()

        val buttons = listOf<Button>(amarTamas , usersList , acceptedJobs , waitigForAcceptJobs,settingPrices , workTara ,usersFeedbacks ,usersSupport, defineState, defineCity, defineNeghbothood, defineJobs, defineNaghsh
                    ,teammates, defineSearchParts, defineSearchBrands, defineSearchGroups, defineSearchDasteha, defineSearchProductsAndServices
        )

        setOnClick(buttons)
        setExitOnClick(exit)
    }

    private fun setNavColor() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        }
    }

    private fun setExitOnClick(exit: Button) {
        exit.setOnClickListener{
            exitProcess(0)
        }
    }

    private fun setOnClick(buttons: List<Button>) {
        for(button in buttons){

            if(button == amarTamas){
                amarTamas.setOnClickListener{
                    val toAmar = Intent(this, AmarTamasActivity::class.java)
                    startActivity(toAmar)
                }
            }
            else if (button == usersList){
                usersList.setOnClickListener{
                    val intent = Intent(this , AppUsersList::class.java)
                    startActivity(intent)
                }
            }
            else if(button == acceptedJobs){
                acceptedJobs.setOnClickListener{
                    val intent = Intent(this , AcceptJobs::class.java)
                    startActivity(intent)
                }
            }

            else if(button == waitigForAcceptJobs){
                waitigForAcceptJobs.setOnClickListener{
                    val intent = Intent(this , WaitingForAcceptanceJobs::class.java)
                    startActivity(intent)
                }
            }

            else if(button == settingPrices){
                settingPrices.setOnClickListener{
                    val intent = Intent(this , Tariffs::class.java)
                    startActivity(intent)
                }
            }

            else if(button == workTara){
                workTara.setOnClickListener{
                    val intent = Intent(this , JobTransactions::class.java )
                    startActivity(intent)
                }
            }

            else if(button == usersSupport){
                usersSupport.setOnClickListener{
                    val intent = Intent(this , UserSupport::class.java )
                    startActivity(intent)
                }
            }

            else if(button == usersFeedbacks){
                usersFeedbacks.setOnClickListener{
                    val intent = Intent(this , UserSendFeedback::class.java )
                    startActivity(intent)
                }
            }

            else {
                button.setOnClickListener {
                    Toast.makeText(
                        this@MainActivity,
                        button.text.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    fun setUi(){
        exit = findViewById(R.id.exit)
        amarTamas = findViewById(R.id.amarTamas)
        usersList = findViewById(R.id.listOfAppUsers)
        acceptedJobs = findViewById(R.id.acceptedWorks)
        waitigForAcceptJobs = findViewById(R.id.watingForAcceptanceJobs)
        settingPrices = findViewById(R.id.settingPrices)
        workTara = findViewById(R.id.workTransactions)
        usersFeedbacks = findViewById(R.id.usersFeedbacks)
        usersSupport = findViewById(R.id.usersSupport)
        defineState = findViewById(R.id.stateDefinition)
        defineCity = findViewById(R.id.cityDefinition)
        defineNeghbothood = findViewById(R.id.neighborhoodDefinition)
        defineJobs = findViewById(R.id.jobsDefinition)
        defineNaghsh = findViewById(R.id.naghsODastresi)
        teammates = findViewById(R.id.teammates)
        defineSearchParts = findViewById(R.id.partsSearchngDef)
        defineSearchBrands = findViewById(R.id.searchingInBrands)
        defineSearchGroups = findViewById(R.id.channelsSearch)
        defineSearchDasteha = findViewById(R.id.partsSearch)
        defineSearchProductsAndServices = findViewById(R.id.productionSearch)
    }


}