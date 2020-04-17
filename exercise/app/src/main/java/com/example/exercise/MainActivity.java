package com.example.exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    private LinearLayout login;
    private LinearLayout info;
    private LinearLayout grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (LinearLayout)findViewById(R.id.layoutLogin);
        info = (LinearLayout)findViewById(R.id.layoutInfo);
        grade = (LinearLayout)findViewById(R.id.layoutGrade);

        final Button btnLogin = (Button)findViewById(R.id.btnLogin);
        final Button btnInfo = (Button)findViewById(R.id.btnInfo);
        final Button btnGrade = (Button)findViewById(R.id.btnGrade);

        btnLogin.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                login.setVisibility(View.VISIBLE);
                info.setVisibility(View.INVISIBLE);
                grade.setVisibility(View.INVISIBLE);
            }
        });
        btnInfo.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                login.setVisibility(View.INVISIBLE);
                info.setVisibility(View.VISIBLE);
                grade.setVisibility(View.INVISIBLE);
            }
        });
        btnGrade.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                login.setVisibility(View.INVISIBLE);
                info.setVisibility(View.INVISIBLE);
                grade.setVisibility(View.VISIBLE);
            }
        });



        login.setVisibility(View.INVISIBLE);
        info.setVisibility(View.INVISIBLE);
        grade.setVisibility(View.INVISIBLE);

    }
}
