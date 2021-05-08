package com.example.arculat;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.FloatEvaluator;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public String input = "";
    public TextView operation;
    public long answerNum;
    public TextView answer;
    public Button btnClear, btnEqual, btnSum, btnMin, btnMulty, btnDivide, btn0, btn1, btn2, btn3, btnDot, btnPer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                this.operation.append(" - ");
                input+=" - ";
                break;
            case R.id.sumation :
                this.operation.append(" + ");
                input+=" + ";
                break;
            case R.id.divide :
                this.operation.append(" / ");
                input+=" / ";
                break;
            case R.id.multiply :
                this.operation.append(" * ");
                input+= " * ";
                break;
            case R.id.percentage :
                this.operation.append(" % ");
                input+= " % ";
                break;
            case R.id.openPra :
                this.operation.append("( ");
                input+= "( ";
                break;
            case R.id.dot :
                this.operation.append(".");
                input+= ".";
                break;
            case R.id.closePra :
                this.operation.append(" )");
                input+= " )";
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

        String re [] = input.split(" ");
        System.out.println("Input : " + input);
        try {
            for (int i = 0; i < re.length; i++) {
                float temp = 0 ;
                String res = re[i];
                if (i >= 1) {
                    if (res.contains("+")) {
                        float fNum = Float.parseFloat(re[i - 1]);
                        float sNum = Float.parseFloat(re[i + 1]);

                        temp = fNum + sNum;
                        re[i - 1] = "";
                        re[i] = "";
                        re[i + 1] = String.valueOf(temp);
                        System.out.println("Answer : " + re[i+1]);
                        this.answer.setText(re[i+1]);
                    }

                    if(res.contains("-")){
                            float fNum = Float.valueOf(re[i-1]);
                            float sNum = Float.valueOf(re[i+1]);

                            temp = fNum - sNum ;
                            re[i - 1] = "";
                            re[i] = "";
                            re[i + 1] = String.valueOf(temp);
                            System.out.println("Answer : " + re[i+1]);
                            this.answer.setText(re[i+1]);
                        }
                        if(res.contains("*")){
                            float fNum = Float.valueOf(re[i-1]);
                            float sNum = Float.valueOf(re[i+1]);

                            temp = fNum * sNum;
                            re[i-1] = "";
                            re[i] = "";
                            re[i+1] = String.valueOf(temp);
                            System.out.println("Answer : " + re[i+1]);
                            this.answer.setText(re[i+1]);
                        }
                        if (re[i].contains("%")){
                            float op1 = Float.parseFloat(re[i-1]);
                            float op2 = Float.parseFloat(re[i+1]);
                            temp = op1 * op2 / 100 ;
                            if (op2 == 0){
                                Toast.makeText(this , "Second Parameter couldn't be 0 !" , Toast.LENGTH_LONG).show();
                            }
                            re[i-1] = "";
                            re[i] = "";
                            re[i+1] = String.valueOf(temp);

                            this.answer.setText(re[i+1]);
                        }
                        if (res.contains("/")){
                            float fNum = Float.valueOf(re[i-1]);
                            float sNum = Float.valueOf(re[i+1]);

                            temp = fNum / sNum;
                            re[i-1] = "";
                            re[i] = "";
                            re[i+1] = String.valueOf(temp);
                            System.out.println("Answer : " + re[i+1]);
                            this.answer.setText(re[i+1]);
                        }
                    }
                    if(input.contains(" ( ") || input.contains("( ")){
                        try {
                            System.out.println("If clause is working ...");
                            if (input.contains(" ) ") || input.contains(" )")) {

                                int oPra = input.indexOf("(");
                                int cPra = input.indexOf(")");

                                input.substring(oPra + 1, cPra - 1);
                                float newTemp = Float.valueOf(re[i + 1]);

                                System.out.println("newTemp : " + String.valueOf(newTemp));

                                String beforeInput = "";
                                String afterInput = "";

                                if(cPra + 2 <= input.length()){
                                    afterInput = input.substring(cPra + 2);
                                    afterInput = " " + afterInput ;
                                    System.out.println("AfterInput : " + afterInput);
                                }
                                if (oPra -1 > 0){
                                    beforeInput = input.substring(0 , oPra - 2);
                                    beforeInput = beforeInput + " " ;
                                    System.out.println("BeforeInput : " + beforeInput);

                                }
                                System.out.println("Total Input : " + beforeInput + afterInput);
                                input = beforeInput + String.valueOf(newTemp) + afterInput ;
                                calculate(input);

                            } else {
                                System.out.println("Pra haven't closed !!");
                                Toast.makeText(this, "Please Close The parenthesis !", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            System.out.println("Error On Paranthesis : " + e);

                        }
                    }
                }
            }catch(Exception e){
                System.out.println("Error : " + e);
            }
    }
}