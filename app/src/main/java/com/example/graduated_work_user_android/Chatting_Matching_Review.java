package com.example.graduated_work_user_android;

import android.os.Bundle;
import android.widget.RatingBar;

import android.app.Activity;

public class Chatting_Matching_Review extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RatingBar ratingbar = (RatingBar)findViewById(R.id.ratingBar);
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            }
        });
    }
}
