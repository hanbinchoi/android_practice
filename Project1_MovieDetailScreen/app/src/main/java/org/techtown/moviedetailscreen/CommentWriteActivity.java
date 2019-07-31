package org.techtown.moviedetailscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class CommentWriteActivity extends AppCompatActivity {

    RatingBar ratingBar;
    EditText contentsInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_write_activity);
        setTitle("한줄평 작성");

        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        contentsInput = (EditText)findViewById(R.id.contentsInput);

        Button saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveEvent();
            }
        });

        Button cancelButton = (Button)findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent= getIntent();
        processIntent(intent);
    }

    public void processIntent(Intent intent){
        if(intent !=null){
            String userID = intent.getStringExtra("userID");
        }
    }

    public void saveEvent(){
        String contents = contentsInput.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("contents",contents);

        float rating = ratingBar.getRating();
        intent.putExtra("rating",rating);

        setResult(RESULT_OK,intent);

        finish();

    }
}
