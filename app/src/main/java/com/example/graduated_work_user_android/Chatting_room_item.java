package com.example.graduated_work_user_android;

public class Chatting_room_item {

    String name;
    String message;
    String time;

    public Chatting_room_item(String name, String message, String time) {
        this.name = name;
        this.message = message;
        this.time = time;

    }

    //For DB , Empty Constructor
    public Chatting_room_item(){
    }

    //set & get

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String time){
        this.time = time;
    }
}
