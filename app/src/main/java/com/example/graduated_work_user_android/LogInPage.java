package com.example.graduated_work_user_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.graduated_work_user_android.Spring_Connection.HTTPClient;
import com.example.graduated_work_user_android.Spring_Connection.Tesk;

import java.util.HashMap;
import java.util.Map;

public class LogInPage extends Activity {

    EditText ID,PW;
    Button btn1,btn2;

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
                loginValidation(ID.getText().toString(),PW.getText().toString());
            }
        });
    }



    private void loginValidation(String id, String pw) {
        if((id != "") && (pw != "")) {
            // login action
            if(check(id,pw) == true) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(LogInPage.this, "아이디와 비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG).show();
            }
        } else if ((id != "") && (pw == "")){
            // sign in first
            Toast.makeText(LogInPage.this, "비밀번호를 입력하시오", Toast.LENGTH_LONG).show();
        } else {
            // login faile;
            Toast.makeText(LogInPage.this, "로그인 실패", Toast.LENGTH_LONG).show();
        }
    }

    private boolean check(String id, String pw){
        //Tesk networkTask = new Tesk();

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        params.put("pw", pw);
        //객체 호출 안되서 직접 아래 메소드 제작
        if(network(params)){
            return true;
        }else{
            return false;
        }
        //networkTask.execute(params);
    }

    private boolean network(Map<String, String>... param){
        String ip = "192.168.117.201";

        HTTPClient.Builder http = new HTTPClient.Builder
                ("POST", "http://" + ip + ":8080/Android"); //address

        // Parameter 를 전송한다.
        http.addAllParameters(param[0]);

        //Http 요청 전송
        HTTPClient post = http.create();
        post.request();

        // 응답 상태코드 가져오기
        int statusCode = post.getHttpStatusCode();

        // 응답 본문 가져오기
        String body = post.getBody();

        if(body.equals("true")){
            return true;
        }else{
            return false;
        }
    }
}



