package com.example.aamersohail.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,equal,plus,minus,multiplication,division,percentage,history,ac;
    TextView display;
    long temp;
    String TAG;
    String str,operation;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setIds();
        myclick();

    }
    public void setIds(){
        display=findViewById(R.id.display);
        b0=findViewById(R.id.b0);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        b0=findViewById(R.id.b0);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        equal=findViewById(R.id.equal);
        multiplication=findViewById(R.id.multiplication);
        division=findViewById(R.id.division);
        TAG=MainActivity.class.getSimpleName();
        percentage=findViewById(R.id.percentage);
        intent=new Intent(MainActivity.this,Main2Activity.class);
        history=findViewById(R.id.history);
        ac=findViewById(R.id.ac);
    }
    public void myclick(){
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplay(0);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplay(1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplay(2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplay(3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplay(4);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplay(5);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplay(6);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplay(7);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplay(8);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplay(9);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performEqual();
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addition();
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtraction();
            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMultiplication();
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDivision();
            }
        });
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPercentage();
            }
        });


        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);

            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str="";
                temp=0;
                display.setText(str);
            }
        });
    }





    public void changeDisplay(int x){
        str=display.getText().toString();
        str=str+x;
        display.setText(str);
    }


    public void addition(){
        temp=Integer.parseInt(str);
        str="";
        display.setText(str);
        operation="+";
    }


    public void subtraction(){
        temp=Integer.parseInt(str);
        str=null;
        display.setText(str);
        operation="-";

    }

    public void setMultiplication(){
        temp=Integer.parseInt(str);
        display.setText(str="");
        operation="*";
    }

    public void setDivision(){
        temp=Integer.parseInt(str);
        display.setText(str="");
        operation="/";
    }

    public void setPercentage(){
        temp=Integer.parseInt(str);
        display.setText(str="");
        operation="%";

    }


    public void performEqual(){
        Long result;
        switch (operation){
            case "+":{
                result=Long.parseLong(str)+temp;
                str=Long.toString(result);
                display.setText(str);
                operation="=";
                break;}


            case "-":
                result=temp-Long.parseLong(str);
                display.setText(Long.toString(result));
                operation="=";
                break;


            case "*":
                result=temp*Integer.parseInt(str);
                display.setText(Long.toString(result));
                operation="=";
                break;

            case "/":
                result=temp/Long.parseLong(str);
                display.setText(Long.toString(result));
                operation="=";
                break;


            case  "%":
                float per;
                per= temp*100/Long.parseLong(str);
                display.setText(Float.toString(per));
                Log.d(TAG,"Per="+per);
                operation="=";
                break;


            case  "=":
                str="";
                temp=0;
                display.setText(str);



        }


    }

}
