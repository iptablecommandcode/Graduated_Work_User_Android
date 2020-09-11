package com.example.graduated_work_user_android.Spring_Connection;

//check setter getter didn't use
public class DTO {
    private String ID;
    private String Sign_In;
    private String PASSWORD;

    public DTO(String ID, String sign_In, String PASSWORD) {
        this.ID = ID;
        Sign_In = sign_In;
        this.PASSWORD = PASSWORD;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSign_In() {
        return Sign_In;
    }

    public void setSign_In(String sign_In) {
        Sign_In = sign_In;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
