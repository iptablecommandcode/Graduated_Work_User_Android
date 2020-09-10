package com.example.graduated_work_user_android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LogInPage extends Activity {

    EditText id, pw;
    Button account, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText) findViewById(R.id.);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
    }
}


