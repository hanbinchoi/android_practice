package org.techtown.moviedetailscreen;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Comment;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button likeButton;
    Button unlikeButton;
    Button showAllButton;
    TextView likeCountView;
    TextView unlikeCountView;
    ListView listView;
    CommentAdapter adapter;
    ArrayList<CommentItem> items = new ArrayList<CommentItem>();

    int likeCount;
    int unlikeCount;
    boolean likeState=false;
    boolean unlikeState=false;
    DecimalFormat myFormatter = new DecimalFormat("###,###");

    float ratingSum = 0.0f;
    float ratingAvg = 0.0f;
    int userCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeButton=(Button)findViewById(R.id.likeButton);
        likeCountView=(TextView)findViewById(R.id.likeCountView);
        likeCount=Integer.parseInt(likeCountView.getText().toString());

        unlikeButton=(Button)findViewById(R.id.unlikeButton);
        unlikeCountView=(TextView)findViewById(R.id.unlikeCountView);
        unlikeCount=Integer.parseInt(unlikeCountView.getText().toString());

        likeCountView.setText(myFormatter.format(likeCount));
        unlikeCountView.setText(myFormatter.format(unlikeCount));

        likeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(likeState){
                    decrLikeCount();
                }else{
                    incrLikeCount();
                }

                likeState = !likeState;
            }
        });

        unlikeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(unlikeState){
                    decrUnlikeCount();
                }else{
                    incrUnlikeCount();
                }
                unlikeState = !unlikeState;
            }
        });

        listView = (ListView)findViewById(R.id.listView);
        adapter = new CommentAdapter();

        items.add(new CommentItem("liv**","ㅋㅅㅋ",3.0f));
        adapter.addItem(new CommentItem("liv**","ㅋㅅㅋ",3.0f));

        items.add(new CommentItem("liv**","ㅋㅅㅋ",3.0f));
        adapter.addItem(new CommentItem("liv**","ㅋㅅㅋ",3.0f));

        items.add(new CommentItem("liasdasd**","asdasd",3.0f));
        adapter.addItem(new CommentItem("liasdasd**","asdasd",3.0f));

        items.add(new CommentItem("liasdasd**","asdasd",3.0f));
        adapter.addItem(new CommentItem("liasdasd**","asdasd",3.0f));

        items.add(new CommentItem("liasdasd**","asdasd",3.0f));
        adapter.addItem(new CommentItem("liasdasd**","asdasd",3.0f));

        items.add(new CommentItem("liasdasd**","asdasd",3.0f));
        adapter.addItem(new CommentItem("liasdasd**","asdasd",3.0f));

        items.add(new CommentItem("liasdasd**","asdasd",3.0f));
        adapter.addItem(new CommentItem("liasdasd**","asdasd",3.0f));

        items.add(new CommentItem("liasdasd**","asdasd",3.0f));
        adapter.addItem(new CommentItem("liasdasd**","asdasd",3.0f));

        items.add(new CommentItem("liasdasd**","asdasd",3.0f));
        adapter.addItem(new CommentItem("liasdasd**","asdasd",3.0f));

        items.add(new CommentItem("liasdasd**","asdasd",3.0f));
        adapter.addItem(new CommentItem("liasdasd**","asdasd",3.0f));

        items.add(new CommentItem("liasdasd**","asdasd",3.0f));
        adapter.addItem(new CommentItem("liasdasd**","asdasd",3.0f));

        items.add(new CommentItem("liasdasd**","asdasd",3.0f));
        adapter.addItem(new CommentItem("liasdasd**","asdasd",3.0f));

        items.add(new CommentItem("liasdasd**","asdasd",3.0f));
        adapter.addItem(new CommentItem("liasdasd**","asdasd",3.0f));

        items.add(new CommentItem("liasdasd**","asdasd",3.0f));
        adapter.addItem(new CommentItem("liasdasd**","asdasd",3.0f));

        items.add(new CommentItem("liasdasd**","asdasd",3.0f));
        adapter.addItem(new CommentItem("liasdasd**","asdasd",3.0f));

        ratingSum = 15*3.0f;
        userCount = 15;
        ratingAvg = ratingSum/userCount;

        listView.setAdapter(adapter);


        //작성하기 버튼
        Button writeButton = (Button)findViewById(R.id.writeButton);
        writeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showCommentWriteActivity();
            }
        });

        //모두보기 버튼
        showAllButton=(Button)findViewById(R.id.showAllButton);
        showAllButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showAllCommentActivity();
            }
        });


    }

    //작성하기 버튼 이벤트
    public void showCommentWriteActivity(){

        Intent intent = new Intent(getApplicationContext(),CommentWriteActivity.class);
        intent.putExtra("userID","livid");
        startActivityForResult(intent,101);
    }

    //모두보기 버튼 이벤트
    public void showAllCommentActivity(){

        Intent intent = new Intent(getApplicationContext(),ShowAllCommentActivity.class);
        intent.putExtra("ratingAvg",ratingAvg);
        intent.putExtra("userCount",userCount);
        intent.putParcelableArrayListExtra("items",items);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == 101){
            if(intent != null){
                String contents = intent.getStringExtra("contents");
                float rating = intent.getFloatExtra("rating",0.0f);

                adapter.addItem(new CommentItem("livid",contents,rating));
                items.add(new CommentItem("livid",contents,rating));

                ratingSum = ratingSum + rating;
                userCount++;
                ratingAvg = ratingSum/userCount;
                listView.setAdapter(adapter);
            }
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


    public void incrLikeCount(){
        if(unlikeState){
            likeCount++;
            likeCountView.setText(myFormatter.format(likeCount));
            likeButton.setBackgroundResource(R.drawable.thumb_up_selected);

            unlikeCount--;
            unlikeState = !unlikeState;
            unlikeCountView.setText(myFormatter.format(unlikeCount));
            unlikeButton.setBackgroundResource(R.drawable.thumbs_down_selector);

        }else{
            likeCount++;
            likeCountView.setText(myFormatter.format(likeCount));
            likeButton.setBackgroundResource(R.drawable.thumb_up_selected);


        }
    }

    public void decrLikeCount(){
        likeCount--;
        likeCountView.setText(myFormatter.format(likeCount));
        likeButton.setBackgroundResource(R.drawable.thumbs_up_selector);
    }

    public void incrUnlikeCount(){
        if(likeState){
            unlikeCount++;
            unlikeCountView.setText(myFormatter.format(unlikeCount));
            unlikeButton.setBackgroundResource(R.drawable.thumb_down_selected);

            likeCount--;
            likeState = !likeState;
            likeCountView.setText(myFormatter.format(likeCount));
            likeButton.setBackgroundResource(R.drawable.thumbs_up_selector);
        }else{
            unlikeCount++;
            unlikeCountView.setText(myFormatter.format(unlikeCount));
            unlikeButton.setBackgroundResource(R.drawable.thumb_down_selected);


        }
    }

    public void decrUnlikeCount(){
        unlikeCount--;
        unlikeCountView.setText(myFormatter.format(unlikeCount));
        unlikeButton.setBackgroundResource(R.drawable.thumbs_down_selector);
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


