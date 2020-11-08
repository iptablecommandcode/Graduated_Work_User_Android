package com.example.graduated_work_user_android;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.graduated_work_user_android.Spring_Connection.JsonToString;
import com.example.graduated_work_user_android.Spring_Connection.NetworkTask;

import java.util.concurrent.ExecutionException;

public class Chatting_Loading extends Activity {

    ImageView Loading;
    Button cancelmatch;
    String UserId, Menu;

    //disable android back button
    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatting_loading);

        Loading = (ImageView) findViewById(R.id.Loading);
        cancelmatch = (Button) findViewById(R.id.cancelmatch);

        //로딩화면 애니메이션
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        Loading.setAnimation(animation);

        //로그인 계정과 선택한 메뉴
        Intent getIntent = getIntent();
        UserId = getIntent.getStringExtra("id");
        Menu = getIntent.getStringExtra("menu");

        //핸들러 이용해 매칭 2초마다 찾기
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //결과값 참 나올때까지 돌리기
                if (people_Check()==true) {
                    //값 전송하기
                    Intent intent = new Intent(getApplicationContext(), Chatting_room_main.class);
                    intent.putExtra("id",UserId);
                    intent.putExtra("menu",Menu);
                    startActivity(intent);
                } else {
                    handler.postDelayed(this,2000);
                }
            }
        },0);

        cancelmatch.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //로그인된 페이지로
                Intent intent = new Intent(getApplicationContext(), Main_SignIn.class);
                intent.putExtra("id",UserId);
                startActivity(intent);
            }
        });
    }

    private boolean people_Check(){
        //DB접속 주소
        final String url = "http://192.168.117.201:8080/Android_Chatting_Search";
        String totalpeople = null;
        //요청 값 ContentValues로 보내기
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",UserId);
        contentValues.put("menu",Menu);

        NetworkTask networkTask = new NetworkTask(url,contentValues);
        //값 처리
        try {
            totalpeople = networkTask.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JsonToString jsonToString = new JsonToString(totalpeople,"Search");
        return jsonToString.changeTrueFalse();
    }
}
