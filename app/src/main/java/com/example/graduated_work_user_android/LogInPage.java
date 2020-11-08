package com.example.graduated_work_user_android;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.graduated_work_user_android.Spring_Connection.JsonToString;
import com.example.graduated_work_user_android.Spring_Connection.NetworkTask;

import java.util.concurrent.ExecutionException;

public class LogInPage extends Activity {

    EditText ID,PW;
    Button btn1,btn2;
    String UserID, UserPW;

    //DB접속 주소
    String url = "http://192.168.117.201:8080/AndroidSign_In";

    //disable android back button
    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        ID = (EditText) findViewById(R.id.edit1);
        PW = (EditText) findViewById(R.id.edit2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);


        //Sign_Up
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Account.class);
                startActivity(intent);
            }
        });

        //Sign_In
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserID = ID.getText().toString();
                UserPW = PW.getText().toString();
                loginValidation(UserID,UserPW);
            }
        });
    }

    private void loginValidation(String id, String pw) {
        if((id.equals("")) && (pw.equals(""))) {
            //id,pw null
            Toast.makeText(LogInPage.this, "아이디와 비밀번호를 입력하시오", Toast.LENGTH_LONG).show();
        } else if ((id != "") && (pw == "")){
            // sign in first
            Toast.makeText(LogInPage.this, "비밀번호를 입력하시오", Toast.LENGTH_LONG).show();
        } else if ((id != "") && (pw != "")) {
            // login action
            if (check(id, pw) == true) {
                Intent intent = new Intent(this, Main_SignIn.class);
                intent.putExtra("id",id);
                startActivity(intent);
            } else {
                Toast.makeText(LogInPage.this, "아이디와 비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG).show();
            }
        }
    }

    //로그인 확인
    public boolean check(String id, String pw){
        if(usedatabase(id,pw))
            return true;
        else
            return false;
    }

    //DB값 전송후 처리된 json값 가져와 String결과값 반환
    private boolean usedatabase(String id, String pw){
        String Signcheck = null;

        //요청 값 ContentValues로 보내기
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("pw",pw);

        NetworkTask networkTask = new NetworkTask(url,contentValues);
        //값 처리
        try {
            //결과 값 가져오기 Spring collection에서 json값 가져오기
            Signcheck = networkTask.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //json값에서 String으로 변환하기
        JsonToString jsonToString = new JsonToString(Signcheck,"Sign_In");

        return jsonToString.changeTrueFalse();
    }
}



