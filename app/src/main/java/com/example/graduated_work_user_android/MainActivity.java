package com.example.graduated_work_user_android;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button Sign_In;

    //disable android back button
    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button
        Sign_In = (Button) findViewById(R.id.Sign_In);
        Button chicken = (Button) findViewById(R.id.chicken);
        Button pizza = (Button) findViewById(R.id.pizza);
        Button pasta = (Button) findViewById(R.id.pasta);
        Button koreanfood = (Button) findViewById(R.id.koreanfood);
        Button chinesefood = (Button) findViewById(R.id.chinesefood);
        Button japanesefood = (Button) findViewById(R.id.japanesefood);
        Button Review = (Button) findViewById(R.id.Review);

        //로그인 하지 않았을때 메세지 생성
        final Toast SignMsg = Toast.makeText(getApplicationContext(), "로그인을 하십시오", Toast.LENGTH_SHORT);

        Sign_In.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), LogInPage.class);
                startActivity(intent);
            }
        });

        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignMsg.show();
            }
        });

        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignMsg.show();
            }
        });

        pasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignMsg.show();
            }
        });

        koreanfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignMsg.show();
            }
        });

        chinesefood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignMsg.show();
            }
        });

        japanesefood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignMsg.show();
            }
        });

        Review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Chatting_Matching_Review.class);
                startActivity(intent);
            }
        });
    }
}