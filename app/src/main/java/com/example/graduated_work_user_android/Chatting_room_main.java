package com.example.graduated_work_user_android;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.graduated_work_user_android.Spring_Connection.NetworkTask;

public class Chatting_room_main extends Activity {

    Button backspace, send;
    ListView chatlist;
    EditText chat;

    //disable android back button
    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatting_room_main);

        final String ID, URL = "http://192.168.117.201:8080/Android_Chatting_main";

        backspace = findViewById(R.id.backspace);
        chatlist = findViewById(R.id.chatlist);
        send = findViewById(R.id.send);
        chat = findViewById(R.id.chat);

        //로그인 계정 정보 가져오기
        Intent getintent = getIntent();
        ID = getintent.getStringExtra("id");

        //전송키
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues contentValues = new ContentValues();
                contentValues.put("id",ID);
                contentValues.put("chat",chat.getText().toString());

                NetworkTask networkTask = new NetworkTask(URL,contentValues);

                networkTask.execute();
            }
        });

        //채팅 종료
        backspace.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chatting_room_main.this, Chatting_Matching_Review.class);
                startActivity(intent);
            }
        });
    }
}
