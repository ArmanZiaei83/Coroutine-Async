package com.example.doctorreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    public EditText userName;

    public RadioGroup doctors;
    public RadioButton doctorsRadBtn;

    public RadioGroup hours;
    public RadioButton hoursRadioBtn;

    public RadioGroup days;
    public RadioButton daysRadioBtn;

    public Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedDoctorsId = doctors.getCheckedRadioButtonId();
                doctorsRadBtn = findViewById(checkedDoctorsId);
                String getDoctorName = doctorsRadBtn.getText().toString();

                int checkedDaysId = days.getCheckedRadioButtonId();
                daysRadioBtn = findViewById(checkedDaysId);
                String getDaysName = daysRadioBtn.getText().toString();

                int checkedHoursId = hours.getCheckedRadioButtonId();
                hoursRadioBtn = findViewById(checkedHoursId);
                String getHourAmount = hoursRadioBtn.getText().toString();

                System.out.println(getDoctorName + getDaysName + getHourAmount);

            }
        });
    }

    public void initialize(){

        userName = findViewById(R.id.userName);
        doctors = findViewById(R.id.doctors);
        hours = findViewById(R.id.hours);
        days = findViewById(R.id.days);

        submit = findViewById(R.id.submit);
    }
}