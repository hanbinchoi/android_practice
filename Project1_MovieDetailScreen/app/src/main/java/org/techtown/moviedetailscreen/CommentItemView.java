package org.techtown.moviedetailscreen;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CommentItemView extends LinearLayout {

    TextView userIdText;
    TextView commentText;
    public CommentItemView(Context context) {
        super(context);
        init(context);
    }

    public CommentItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_item_view,this,true);
        //리니어 레이아웃을 상속받앗으므로 여기에 뷰를 받을수있는거임

        userIdText = (TextView)findViewById(R.id.userID);
        commentText = (TextView)findViewById(R.id.comment);

    }

    public void setUserID(String userID) {
        userIdText.setText(userID);
    }
    public void setComment(String comment) {
        commentText.setText(comment);
    }
}
