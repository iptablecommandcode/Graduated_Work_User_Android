package com.example.graduated_work_user_android;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
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
    }



    private boolean loginValidation(String id, String pw) {
        if(pref.getString("id","").equals(id) && pref.getString("pw","").equals(pw)) {
            // login success
            return true;
        } else if (pref.getString("id","").equals(null)){
            // sign in first
            Toast.makeText(LogInPage.this, "Please Sign in first", Toast.LENGTH_LONG).show();
            return false;
        } else {
            // login failed
            return false;
        }
    }
}



