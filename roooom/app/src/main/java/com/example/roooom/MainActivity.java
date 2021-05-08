package com.example.roooom;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roooom.AccessDataBase.DataManager;
import com.example.roooom.AccessDataBase.RxForData;

public class MainActivity extends AppCompatActivity implements DataManager {

    DataManager dataManager;
    RxForData rx;
    String email;
    String pass;

    EditText userEmail;
    EditText userPass;


    Button sendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        rx = new RxForData(this);
        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Strings Form EditText:
                email = userEmail.getText().toString();
                pass = userPass.getText().toString();

                if(email.isEmpty() || email == null || pass.isEmpty() || pass == null){
                    onFailure();
                }else{
                    if (email.length() < 9 || pass.length() < 9 ){

                        onFailure();
                    }else {
                        onSuccess();
                        rx.addToDb(dataManager ,email , pass);
                        rx.getAllData();
                    }
                }
            }
        });

    }

    private void initView() {

        sendData = findViewById(R.id.submit);
        userEmail = findViewById(R.id.email);
        userPass = findViewById(R.id.pass);



    }

    @Override
    public void onSuccess() {
        makeToast("Data Added Successfully");
    }

    @Override
    public void onFailure() {
        makeToast("Failed To Add Data To DataBase");
    }

    @Override
    public void onUpdate() {
        makeToast("Data Updated");
    }


    public void makeToast(String message){
        Toast.makeText(this , message , Toast.LENGTH_SHORT).show();
    }

}