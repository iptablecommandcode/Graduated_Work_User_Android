package com.example.graduated_work_user_android;

import android.widget.EditText;

public class AccountCheck {
    private String ID, NAME, PW, PWCHK, PHONE, EMAIL, SCHOOL, NULL;

    AccountCheck(EditText ID, EditText NAME, EditText PW, EditText PWCHK, EditText PHONE, EditText EMAIL, EditText SCHOOL, EditText NULL){
        this.ID = ID.getText().toString();
        this.NAME = NAME.getText().toString();
        this.PW = PW.getText().toString();
        this.PWCHK = PWCHK.getText().toString();
        this.PHONE = PHONE.getText().toString();
        this.EMAIL = EMAIL.getText().toString();
        this.SCHOOL = SCHOOL.getText().toString();
        this.NULL = NULL.getText().toString();
    }

    //account data check
    // return 1 is true
    // return 2 is empty something
    // return 3 is password not match
    public int TotalCheck(){
        if (EmptyChk() == false)
            return 2;
        if(PasswordCheck() == false)
            return 3;
        return 1;
    }

    //emptycheck
    boolean EmptyChk(){
        if(ID.equals(NULL))
            return false;
        else if(NAME.equals(NULL))
            return false;
        else if(PW.equals(NULL))
            return false;
        else if(PWCHK.equals(NULL))
            return false;
        else if(PHONE.equals(NULL))
            return false;
        else if(EMAIL.equals(NULL))
            return false;
        else if(SCHOOL.equals(NULL))
            return false;
        return true;
    }

    boolean PasswordCheck(){
        if (PW.equals(PWCHK))
            return true;
        return false;
    }
}
