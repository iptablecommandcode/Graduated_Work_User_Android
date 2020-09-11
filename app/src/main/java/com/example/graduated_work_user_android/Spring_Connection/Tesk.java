package com.example.graduated_work_user_android.Spring_Connection;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.util.Map;

//input
//Communication servlet class
public class Tesk extends AsyncTask<Map<String, String>, Integer, String> {

    public static String ip = "192.168.117.201"; //Your IP

    @Override
    protected String doInBackground(Map<String, String>... maps) { // wanna sending parmeter

        HTTPClient.Builder http = new HTTPClient.Builder
                ("POST", "http://" + ip + ":8080/Android"); //address

        // Parameter 를 전송한다.
        http.addAllParameters(maps[0]);

        //Http 요청 전송
        HTTPClient post = http.create();
        post.request();

        // 응답 상태코드 가져오기
        int statusCode = post.getHttpStatusCode();

        // 응답 본문 가져오기
        String body = post.getBody();

        return body;
    }

    //print test
    @Override
    public void onPostExecute(String s) { //서블릿으로부터 값을 받을 함수

        Gson gson = new Gson();
        DTO data = gson.fromJson(s, DTO.class);

        data.getSign_In();
    }
}