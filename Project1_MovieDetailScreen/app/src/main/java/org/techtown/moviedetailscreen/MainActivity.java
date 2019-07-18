package org.techtown.moviedetailscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView up;
    ImageView up_selected;
    ImageView down;
    ImageView down_selected;
    // 좋아요 싫어요 이미지를 저장할 변수들

    int index=0;
    int index2=0;
    int a=1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        up = (ImageView)findViewById(R.id.up);
        up_selected = (ImageView)findViewById(R.id.up_selected);
        down = (ImageView)findViewById(R.id.down);
        down_selected = (ImageView)findViewById(R.id.down_selected);

        //이미지를 변수에 저장합니다.

    }

    //좋아요 이미지를 클릭햇을때 이벤트
    public void onButton1Clicked(View v){
        index+=1;
        if(index>1){
            index=0;
        }
        if(index==0){
            up.setVisibility(View.VISIBLE);
            up_selected.setVisibility(View.INVISIBLE);

        }else if(index==1)
        {
            up.setVisibility(View.INVISIBLE);
            up_selected.setVisibility((View.VISIBLE));
        }
    }
    public void onButton2Clicked(View v){
        index2 += 1;
        if(index2>1){
            index2=0;
        }
        if(index2==0){
            down.setVisibility(View.VISIBLE);
            down_selected.setVisibility(View.INVISIBLE);

        }else if(index2==1)
        {
            down.setVisibility(View.INVISIBLE);
            down_selected.setVisibility((View.VISIBLE));
        }
    }

}
