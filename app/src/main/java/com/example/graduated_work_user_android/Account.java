package com.example.graduated_work_user_android;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import android.app.Activity;

import com.example.graduated_work_user_android.Spring_Connection.JsonToString;
import com.example.graduated_work_user_android.Spring_Connection.NetworkTask;

import java.util.concurrent.ExecutionException;

public class Account extends Activity {

    EditText ID, NAME, PW, PWCHK, PHONE, EMAIL, SCHOOL, NULL;
    CheckBox LICENSECHK1, LICENSECHK2, LICENSECHK3;
    Button LICENSE1, LICENSE2, LICENSE3, BACK, Sign_In, IdChk;
    RadioGroup GENDER;

    boolean idChk=false;
    String CheckGender;

    //disable android back button
    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

        //value input
        //Text
        ID = (EditText) findViewById(R.id.ID);
        NAME = (EditText) findViewById(R.id.NAME);
        PW = (EditText) findViewById(R.id.PW);
        PWCHK = (EditText) findViewById(R.id.PWCHK);
        PHONE = (EditText) findViewById(R.id.PHONE);
        EMAIL = (EditText) findViewById(R.id.EMAIL);
        SCHOOL = (EditText) findViewById(R.id.SCHOOL);
        NULL = (EditText) findViewById(R.id.NULL);

        //Button
        BACK = (Button) findViewById(R.id.BACK);
        Sign_In = (Button) findViewById(R.id.Sign_In);
        LICENSE1 = (Button) findViewById(R.id.LICENSE1);
        LICENSE2 = (Button) findViewById(R.id.LICENSE2);
        LICENSE3 = (Button) findViewById(R.id.LICENSE3);
        IdChk = (Button) findViewById(R.id.IdChk);

        //RadioGroup
        GENDER = (RadioGroup) findViewById(R.id.GENDER);
        int gender = GENDER.getCheckedRadioButtonId();
        final RadioButton SEX = (RadioButton) findViewById(gender);
        CheckGender = SEX.getText().toString();

        //Check Box
        LICENSECHK1 = (CheckBox) findViewById(R.id.LICENSECHK1);
        LICENSECHK2 = (CheckBox) findViewById(R.id.LICENSECHK2);
        LICENSECHK3 = (CheckBox) findViewById(R.id.LICENSECHK3);

        //Back_Main_Page
        IdChk.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast ErrMsg = Toast.makeText(getApplicationContext(), "사용 불가능한 ID입니다.", Toast.LENGTH_SHORT);
                Toast CorrMsg = Toast.makeText(getApplicationContext(), "사용 가능한 ID입니다.", Toast.LENGTH_SHORT);

                if(Id_Check()){
                    ErrMsg.show();
                    idChk = false;
                }else{
                    CorrMsg.show();
                    idChk = true;
                }
            }
        });

        //Sign_Up
        Sign_In.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast EmpMsg = Toast.makeText(getApplicationContext(), "값을 입력하십시오", Toast.LENGTH_SHORT);
                Toast PasMsg = Toast.makeText(getApplicationContext(), "비밀번호가 맞지 않습니다.", Toast.LENGTH_SHORT);
                Toast ChkMsg = Toast.makeText(getApplicationContext(), "약관에 동의하시기 바랍니다.", Toast.LENGTH_SHORT);
                Toast IdChkMsg = Toast.makeText(getApplicationContext(), "중복확인을 하지 않았습니다.", Toast.LENGTH_SHORT);

                //check
                //account data check
                // return 1 is true
                // return 2 is empty something
                // return 3 is password not match
                // return 4 is License didn't check
                // return 5 is idChk fail
                AccountCheck accountCheck = new AccountCheck(ID, NAME, PW, PWCHK, PHONE, EMAIL, SCHOOL, NULL, SEX, LICENSECHK1, LICENSECHK2, LICENSECHK3, idChk);
                int check = accountCheck.TotalCheck();

                //select message
                if(check==1){
                    //save
                    Sign_Up();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }else if(check==2){
                    EmpMsg.show();
                }else if(check==3){
                    PasMsg.show();
                }else if(check==4){
                    ChkMsg.show();
                }else if(check==5){
                    IdChkMsg.show();
                }
            }
        });

        //Back_Main_Page
        BACK.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //LICENSE1_Page
        LICENSE1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Account_License.class);
                startActivity(intent);
            }
        });

        //LICENSE2_Page
        LICENSE2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Account_License2.class);
                startActivity(intent);
            }
        });

        //LICENSE3_Page
        LICENSE3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Account_License3.class);
                startActivity(intent);
            }
        });

    }

    //DB값 전송후 처리된 json값 가져와 String결과값 반환
    private void Sign_Up(){
        //DB접속 주소
        String url = "http://192.168.117.201:8080/Account/Sign_Up";

        //요청 값 ContentValues로 보내기
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID",ID.getText().toString());
        contentValues.put("NAME",NAME.getText().toString());
        contentValues.put("PASSWORD",PW.getText().toString());
        contentValues.put("GENDER",CheckGender);
        contentValues.put("PHONE",NAME.getText().toString());
        contentValues.put("EMAIL",NAME.getText().toString());
        contentValues.put("SCHOOL",NAME.getText().toString());

        NetworkTask networkTask = new NetworkTask(url,contentValues);
        //값 처리
        try {
            networkTask.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //결과 값 가져오기 Spring collection에서 json값 확인
    }

    //DB값 전송후 처리된 json값 가져와 String결과값 반환
    private boolean Id_Check(){
        //DB접속 주소
        final String url = "http://192.168.117.201:8080/Account/Search_ID";
        String idChkVal = ID.getText().toString();
        //결과값 json 받기용
        String Signcheck = null;

        //요청 값 ContentValues로 보내기
        ContentValues contentValues = new ContentValues();
        if(idChkVal.equals(""))
            return false;
        else
            contentValues.put("ID", idChkVal);

        NetworkTask networkTask = new NetworkTask(url,contentValues);
        //값 처리
        try {
            Signcheck = networkTask.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //json값 String으로 추출
        JsonToString jsonToString = new JsonToString(Signcheck);

        return jsonToString.changeTrueFalse();
    }

}
