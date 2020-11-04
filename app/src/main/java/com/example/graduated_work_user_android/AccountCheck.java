package com.example.graduated_work_user_android;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class AccountCheck {
    private String ID, NAME, PW, PWCHK, PHONE, EMAIL, SCHOOL, NULL, SEX;
    CheckBox LICENSECHK1, LICENSECHK2, LICENSECHK3;
    boolean IDCHK;

    AccountCheck(EditText ID, EditText NAME, EditText PW, EditText PWCHK, EditText PHONE, EditText EMAIL, EditText SCHOOL, EditText NULL, RadioButton SEX, CheckBox LICENSECHK1, CheckBox LICENSECHK2, CheckBox LICENSECHK3, boolean IDCHK){
        //clear and setting
        this.ID = ID.getText().toString();
        this.NAME = NAME.getText().toString();
        this.PW = PW.getText().toString();
        this.PWCHK = PWCHK.getText().toString();
        this.PHONE = PHONE.getText().toString();
        this.EMAIL = EMAIL.getText().toString();
        this.SCHOOL = SCHOOL.getText().toString();
        this.NULL = NULL.getText().toString();
        this.SEX = SEX.getText().toString();
        this.LICENSECHK1 = LICENSECHK1;
        this.LICENSECHK2 = LICENSECHK2;
        this.LICENSECHK3 = LICENSECHK3;
        this.IDCHK = IDCHK;
    }

    //account data check
    // return 1 is true
    // return 2 is empty something
    // return 3 is password not match
    public int TotalCheck(){
        if (EmptyChk() == false)
            return 2;
        if(PasswordChk() == false)
            return 3;
        if(LicenseChK() == false)
            return 4;
        if(IDCHK == false)
            return 5;
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

    boolean PasswordChk(){
        if (PW.equals(PWCHK))
            return true;
        return false;
    }

    boolean LicenseChK(){
        if(LICENSECHK1.isChecked())
            if (LICENSECHK2.isChecked())
                if (LICENSECHK3.isChecked())
                    return true;
        return false;
    }
}
