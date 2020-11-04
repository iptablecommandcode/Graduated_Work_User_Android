package com.example.graduated_work_user_android;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button Sign_In;

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



        Sign_In.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), LogInPage.class);
                startActivity(intent);
            }
        });

        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //채팅로딩을 만들기 전이라 Account로 이동하게 해놨음 추후 Chatting_loding으로 변경
                Intent intent = new Intent(getApplicationContext(), Account.class);
                startActivity(intent);
            }
        });

        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //채팅로딩을 만들기 전이라 Account로 이동하게 해놨음 추후 Chatting_loding으로 변경
                Intent intent = new Intent(getApplicationContext(), Account.class);
                startActivity(intent);
            }
        });

        pasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //채팅로딩을 만들기 전이라 Account로 이동하게 해놨음 추후 Chatting_loding으로 변경
                Intent intent = new Intent(getApplicationContext(), Account.class);
                startActivity(intent);
            }
        });

        koreanfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //채팅로딩을 만들기 전이라 Account로 이동하게 해놨음 추후 Chatting_loding으로 변경
                Intent intent = new Intent(getApplicationContext(), Account.class);
                startActivity(intent);
            }
        });

        chinesefood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //채팅로딩을 만들기 전이라 Account로 이동하게 해놨음 추후 Chatting_loding으로 변경
                Intent intent = new Intent(getApplicationContext(), Account.class);
                startActivity(intent);
            }
        });

        japanesefood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //채팅로딩을 만들기 전이라 Account로 이동하게 해놨음 추후 Chatting_loding으로 변경
                Intent intent = new Intent(getApplicationContext(), Account.class);
                startActivity(intent);
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