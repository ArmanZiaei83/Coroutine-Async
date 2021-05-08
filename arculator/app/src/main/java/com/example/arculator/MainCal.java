package com.example.arculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.StatusHints;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.jar.JarOutputStream;

public class MainCal extends AppCompatActivity {

    public String input = "";
    public TextView operation;
    public long answerNum;
    public TextView answer;
    public Button btnClear, btnEqual, btnSum, btnMin, btnMulty, btnDivide, btn0, btn1, btn2, btn3, btnDot, btnPer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cal);
        btn0 = findViewById(R.id.num0);
        btn1 = findViewById(R.id.num1);
        btn2 = findViewById(R.id.num2);
        btn3 = findViewById(R.id.num3);
        btnMin = findViewById(R.id.minus);
        btnSum = findViewById(R.id.sumation);
        btnDivide = findViewById(R.id.divide);
        btnMulty = findViewById(R.id.multiply);
        btnEqual = findViewById(R.id.equal);
        btnClear = findViewById(R.id.ce);
        btnDot = findViewById(R.id.dot);
        operation = (TextView) findViewById(R.id.operation);
        answer = (TextView) findViewById(R.id.answer);
        btnPer = findViewById(R.id.percentage);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.num0 :
                this.operation.append("0");
                input+="0";
                break;
            case R.id.num1 :
                this.operation.append("1");
                input+="1";
                break;
            case R.id.num2 :
                this.operation.append("2");
                input+="2";
                break;
            case R.id.num3 :
                this.operation.append("3");
                input += "3";
                break;
            case R.id.num4 :
                this.operation.append("4");
                input+="4";
                break;
            case R.id.num5 :
                this.operation.append("5");
                input+="5";
                break;
            case R.id.num6 :
                this.operation.append("6");
                input+="6";
                break;
            case R.id.num7 :
                this.operation.append("7");
                input+="7";
                break;
            case R.id.num8 :
                this.operation.append("8");
                input+="8";
                break;
            case R.id.num9 :
                this.operation.append("9");
                input+="9";
                break;
            case R.id.minus :
                this.operation.append("-");
                input+="-";
                break;
            case R.id.sumation :
                this.operation.append(" + ");
                input+="+";
                break;
            case R.id.divide :
                this.operation.append("/");
                input+="/";
                break;
            case R.id.multiply :
                this.operation.append("*");
                input+= "*";
                break;
            case R.id.percentage :
                this.operation.append("%");
                input+= "%";
                break;
            case R.id.openPra :
                this.operation.append("(");
                input+= "(";
                break;
            case R.id.dot :
                this.operation.append(".");
                input+= ".";
                break;
            case R.id.closePra :
                this.operation.append(")");
                input+= ")";
                break;
            case R.id.equal :
                System.out.println(input);
                calculate(input);
                break;
            case R.id.ce :
                this.operation.setText("");
                input = "";
                break;
        }


    }
    public void calculate(String input){
        char[] res = input.toCharArray();

        sumationCal(res);
//        minusCal();
//        multiplyCal();
//        devideCal();
    }
    public void sumationCal(char[] res){

        float temp ;
        for (int i = 0; i < res.length; i++) {
            System.out.println("res : "  + res[i] );

            if(res[i] == '+'){
                float op1 = Float.parseFloat(String.valueOf(res[i-1]));
                float op2 = Float.parseFloat(String.valueOf(res[i+1]));

                System.out.println("OP1 : " + op1 );
                System.out.println("OP2 : " + op2 );

                temp = op1 + op2;
                res[i] = Character.valueOf((char) temp);
                System.out.println("Res new : " + res[i]);
                res [i-1] = ' ';
                res [i+1] = ' ';
                this.answer.setText(String.valueOf(temp));

            }
        }
    }
}
