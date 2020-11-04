package com.example.graduated_work_user_android.Spring_Connection;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonToString {
    String changeValue = null;
    public JsonToString(String changeValue){
        this.changeValue = changeValue;
    }
    //String에 넣은 json값 꺼내기
    public boolean changeTrueFalse(){
        String reString = null;
        try {
            //json에서 키값 지정해 불러오기
            reString = (String) new JSONObject(changeValue).get("Sign_In");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(reString.equals("true"))
            return true;
        else
            return false;
    }
}
