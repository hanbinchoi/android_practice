package com.example.myfragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements FragmentCallback {

    Fragment1 fragment1;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragment1 != null) {
                    fragment1.onCommandFromActivity("show", "액티비티로 부터 전달됨");
                }
            }
        });
        fragment1 = new Fragment1();
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment1).commit();


    }

    public void onCommand(String command,String data){
        button2.setText(data);
    }
}
