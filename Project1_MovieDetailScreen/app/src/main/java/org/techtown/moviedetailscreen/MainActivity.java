package org.techtown.moviedetailscreen;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    int index=0;
    int index2=0;
    int a=1234;
    View like;
    View unlike;
    TextView likeNum;
    TextView unlikeNum;
    int likeNumInt;
    int unlikeNumInt;
    DecimalFormat myFormatter = new DecimalFormat("###,###");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        like=findViewById(R.id.like);
        likeNum=(TextView)findViewById(R.id.likeNum);
        likeNumInt=Integer.parseInt(likeNum.getText().toString());

        unlike=findViewById(R.id.unlike);
        unlikeNum=(TextView)findViewById(R.id.unlikeNum);
        unlikeNumInt=Integer.parseInt(unlikeNum.getText().toString());

        likeNum.setText(myFormatter.format(likeNumInt));
        unlikeNum.setText(myFormatter.format(unlikeNumInt));

        like.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                if (action == MotionEvent.ACTION_DOWN && index == 0) {
                    index = 1;
                    likeNumInt+=1;
                } else if (action == MotionEvent.ACTION_DOWN && index != 0) {
                    index = 0;
                    likeNumInt-=1;
                }

                if (index == 0) {
                    like.setBackgroundResource(R.drawable.thumb_up);
                    likeNum.setText(myFormatter.format(likeNumInt));

                } else if (index == 1) {
                    like.setBackgroundResource(R.drawable.thumb_up_selected);
                    likeNum.setText(myFormatter.format(likeNumInt));
                }
                return true;
            }
        });

            unlike.setOnTouchListener(new View.OnTouchListener(){
                @Override
            public boolean onTouch(View v, MotionEvent event){
                int action=event.getAction();

                if(action==MotionEvent.ACTION_DOWN && index==0){
                    index=1;
                    unlikeNumInt+=1;
                }else if(action==MotionEvent.ACTION_DOWN && index!=0){
                    index=0;
                    unlikeNumInt-=1;
                }

                if(index==0){
                    unlike.setBackgroundResource(R.drawable.thumb_down);
                    unlikeNum.setText(myFormatter.format(unlikeNumInt));

                }else if(index==1){
                    unlike.setBackgroundResource(R.drawable.thumb_down_selected);
                    unlikeNum.setText(myFormatter.format(unlikeNumInt));
                }
                return true;
            }
        });

    }




    //페이스북, 카톡, 예매하기 버튼클릭스 관련 사이트이동 (앱을 실행시키고 싶지만 모르겠습니다.

    public void onButton3Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
        startActivity(intent);
    }

    public void onButton4Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kakaocorp.com/service/KakaoTalk?lang=ko"));
        startActivity(intent);
    }

    public void onButton5Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cgv.co.kr/"));
        startActivity(intent);
    }
}


