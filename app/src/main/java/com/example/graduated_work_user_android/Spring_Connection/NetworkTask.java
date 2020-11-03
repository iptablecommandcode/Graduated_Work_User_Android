package com.example.graduated_work_user_android.Spring_Connection;

import android.content.ContentValues;
import android.os.AsyncTask;

import java.util.HashMap;

public class NetworkTask extends AsyncTask<Void, Void, String> {

    private static String url="http://192.168.117.201:8080/AndroidSign_In";
    private ContentValues values;
    HashMap<String, String> map;

    public NetworkTask(ContentValues values) {
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
        result = requestHttpURLConnection.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;
    }

//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//
//        //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
//
//    }
}
