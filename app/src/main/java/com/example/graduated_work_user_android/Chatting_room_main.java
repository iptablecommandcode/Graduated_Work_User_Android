package com.example.graduated_work_user_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Chatting_room_main extends Activity {

    Button backspace;
    ListView chatlist;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatting_room_main);

        backspace = findViewById(R.id.backspace);
        chatlist = findViewById(R.id.chatlist);

        backspace.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Chatting_room_main.this, Chatting_Matching_Review.class);
                startActivity(intent);
            }
        });
    }
}
