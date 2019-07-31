package org.techtown.moviedetailscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowAllCommentActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView textView;
    ListView listView;

    float ratingAvg=0.0f;
    int userCount=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("val","여기까지");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_comment);
        setTitle("모두보기");

        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        textView = (TextView)findViewById(R.id.textView);
        listView=(ListView)findViewById(R.id.listView);

        Intent intent = getIntent();
        processIntent(intent);

    }

    public void processIntent(Intent intent){
        if(intent != null){
            ratingAvg = intent.getFloatExtra("ratingAvg",0.0f);
            ratingBar.setRating(ratingAvg);
            userCount = intent.getIntExtra("userCount",0);
            String text = ratingAvg + " (" + userCount +" 명 참여)";
            textView.setText(text);
            ArrayList<CommentItem> items = intent.getParcelableArrayListExtra("items");

            CommentAdapter adapter = new CommentAdapter();

            for(int i=0;i<items.size();i++){
                adapter.addItem(items.get(i));
            }

            listView.setAdapter(adapter);

        }
    }

    class CommentAdapter extends BaseAdapter{

        ArrayList<CommentItem> items = new ArrayList<CommentItem>();


        //처음에 아이템이 몇개 들어있니? 물어봄
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(CommentItem item){

            items.add(item);
        }

        //필요할때 그 데이터를 줄래 (몇번째 데이터니)
        @Override
        public Object getItem(int i) {
            return items.get(i); //i번째 아이템을 리턴
        }


        //id라는 값이 있으면 넘겨달라
        @Override
        public long getItemId(int i) {
            return i; //여기서는 인덱스만 리턴함 실제로는 id를 리턴
        }

        //어댑터가 데이터를 관리하기때문에 데이터 관리하는 어댑터가 화면에 보여질 각각에 아이템을 위한 뷰를 만들어줘라
        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            CommentItemView view = new CommentItemView(getApplicationContext());

            CommentItem item = items.get(i);
            view.setUserID(item.getUserID());
            view.setComment(item.getComment());
            view.setRating(item.getRating());

            return view;
        }
    }



}
