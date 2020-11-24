package com.example.graduated_work_user_android.Spring_Connection;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ChatMessage {
    //채팅 내용
    //사용자 ID
    String ID,ChatList;
    ChatMessage(String ID,String ChatList){
        this.ID = ID;
        this.ChatList = ChatList;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getChatList() {
        return ChatList;
    }

    public void setChatList(String chatList) {
        ChatList = chatList;
    }
}