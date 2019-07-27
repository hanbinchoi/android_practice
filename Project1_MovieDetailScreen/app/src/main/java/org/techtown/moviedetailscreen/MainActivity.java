package org.techtown.moviedetailscreen;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int index=0;
    int index2=0;
    int a=1234;
    Button likeButton;
    Button unlikeButton;
    Button writeButton;
    Button showAllButton;
    TextView likeCountView;
    TextView unlikeCountView;
    int likeCount;
    int unlikeCount;
    boolean likeState=false;
    boolean unlikeState=false;
    DecimalFormat myFormatter = new DecimalFormat("###,###");


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

        ListView listView = (ListView)findViewById(R.id.listView);
        CommentAdapter adapter =new CommentAdapter();
        adapter.addItem(new CommentItem("liv**","ㅋㅅㅋ"));
        adapter.addItem(new CommentItem("liv**","ㅋㅅㅋ"));
        adapter.addItem(new CommentItem("liasdasd**","asdasd"));

        listView.setAdapter(adapter);

        writeButton = (Button)findViewById(R.id.writeButton);
        writeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"작성하기 버튼이 눌렸습니다.",Toast.LENGTH_LONG).show();
            }
        });

        showAllButton=(Button)findViewById(R.id.showAllButton);
        showAllButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "모두보기 버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
            }
        });
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


