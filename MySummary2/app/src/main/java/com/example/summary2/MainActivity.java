package com.example.summary2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button likeButton;
    TextView likeCountView;
    int likeCount = 1;
    boolean likeState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeButton = (Button)findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

                if(likeState){
                    decrLikeCount();
                } else{
                    incrLikeCount();
                }

                likeState= !likeState;
            }
        });


        likeCountView = (TextView)findViewById(R.id.likeCountView);

        ListView listView = (ListView)findViewById(R.id.listView);
        CommentAdapter adapter = new CommentAdapter();
        listView.set
    }

    class CommentAdapter extends BaseAdapter{

        ArrayList items = new ArrayList();

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }

    public void incrLikeCount(){
        likeCount++;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setBackgroundResource(R.drawable.thumb_up_selected);
    }

    public void decrLikeCount(){
        likeCount--;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setBackgroundResource(R.drawable.thumbs_up_selector);
    }


}
