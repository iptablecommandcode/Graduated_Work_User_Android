package com.example.graduated_work_user_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_SignIn extends Activity {

    Button Sign_Out;
    String UserId;

    //disable android back button
    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_signin);

        //Button
        Sign_Out = (Button) findViewById(R.id.Sign_Out);
        Button chicken = (Button) findViewById(R.id.chicken);
        Button pizza = (Button) findViewById(R.id.pizza);
        Button pasta = (Button) findViewById(R.id.pasta);
        Button koreanfood = (Button) findViewById(R.id.koreanfood);
        Button chinesefood = (Button) findViewById(R.id.chinesefood);
        Button japanesefood = (Button) findViewById(R.id.japanesefood);
        Button Review = (Button) findViewById(R.id.Review);

        Intent getIntent = getIntent();
        UserId = getIntent.getStringExtra("id");

        //로그아웃
        Sign_Out.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //치킨
        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Chatting_Loading.class);
                intent.putExtra("id",UserId);
                intent.putExtra("menu","chicken");
                startActivity(intent);
            }
        });

        //피자
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Chatting_Loading.class);
                intent.putExtra("id",UserId);
                intent.putExtra("menu","pizza");
                startActivity(intent);
            }
        });

        //파스타
        pasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Chatting_Loading.class);
                intent.putExtra("id",UserId);
                intent.putExtra("menu","pasta");
                startActivity(intent);
            }
        });

        //한식
        koreanfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Chatting_Loading.class);
                intent.putExtra("id",UserId);
                intent.putExtra("menu","koreanfood");
                startActivity(intent);
            }
        });

        //중식
        chinesefood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Chatting_Loading.class);
                intent.putExtra("id",UserId);
                intent.putExtra("menu","chinesefood");
                startActivity(intent);
            }
        });

        //일식
        japanesefood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Chatting_Loading.class);
                intent.putExtra("id",UserId);
                intent.putExtra("menu","japanesefood");
                startActivity(intent);
            }
        });

        //리뷰
        Review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Chatting_Matching_Review.class);
                intent.putExtra("id",UserId);
                intent.putExtra("menu","Review");
                startActivity(intent);
            }
        });
    }
}