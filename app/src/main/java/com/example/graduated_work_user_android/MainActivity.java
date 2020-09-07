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

        Sign_In.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Account.class);
                startActivity(intent);
            }
        });
        DB_Conn db = new DB_Conn();
        db.DBConn();
    }
}