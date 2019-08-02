package com.example.fragment2;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ListFragment fragment1;
    ViewFragment fragment2;

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        manager=getSupportFragmentManager();

        fragment1 = (ListFragment)manager.findFragmentById(R.id.listFragment);
        fragment2 = (ViewFragment)manager.findFragmentById(R.id.viewFragment);

    }

    public void onImageChange(int index){
        fragment2.setImage(index);
    }
}
