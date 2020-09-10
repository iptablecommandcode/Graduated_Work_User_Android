package com.example.graduated_work_user_android;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInPage extends Activity {

    EditText id,pw;
    Boolean loginChecked;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        id = (EditText) findViewById(R.id.edit1);
        pw = (EditText) findViewById(R.id.edit2);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Account.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginValidation(id.getText().toString(),pw.getText().toString());
            }
        });
    }



    private void loginValidation(String id, String pw) {
        if(pref.getString("id","").equals(id) && pref.getString("pw","").equals(pw)) {
            // login success
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else if (pref.getString("id","").equals(null)){
            // sign in first
            Toast.makeText(LogInPage.this, "Please Sign in first", Toast.LENGTH_LONG).show();

        } else {
            // login faile;
        }
    }
}



