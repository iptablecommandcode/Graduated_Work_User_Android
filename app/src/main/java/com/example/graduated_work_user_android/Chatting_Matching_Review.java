package com.example.graduated_work_user_android;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import android.app.Activity;

import com.example.graduated_work_user_android.Spring_Connection.NetworkTask;

import java.util.concurrent.ExecutionException;

public class Chatting_Matching_Review extends Activity {

    RatingBar ratingbar;
    Button button;
    EditText Review;
    int ChatScore;
    //disable android back button
    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatting_matching_review);

        button = (Button) findViewById(R.id.button);
        ratingbar = (RatingBar)findViewById(R.id.ratingBar);
        Review = (EditText)findViewById(R.id.Review);

        final String ID, URL = "http://192.168.117.201:8080/Android_Review";


        //로그인 계정 정보 가져오기
        Intent getintent = getIntent();
        ID = getintent.getStringExtra("id");


        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
               ChatScore  = (int)rating;
            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                //db전송
                ContentValues contentValues = new ContentValues();
                contentValues.put("ID",ID);
                contentValues.put("CHATSCORE",ChatScore);
                contentValues.put("REVIEW",Review.getText().toString());

                NetworkTask networkTask = new NetworkTask(URL,contentValues);

                try {
                    networkTask.execute().get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(getApplicationContext(), Main_SignIn.class);
                intent.putExtra("id",ID);
                startActivity(intent);
            }
        });
    }
}
