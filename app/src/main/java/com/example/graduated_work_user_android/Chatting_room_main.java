package com.example.graduated_work_user_android;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.graduated_work_user_android.Spring_Connection.ChatMessage;
import com.example.graduated_work_user_android.Spring_Connection.JsonToString;
import com.example.graduated_work_user_android.Spring_Connection.MyChattingAdapter;
import com.example.graduated_work_user_android.Spring_Connection.NetworkTask;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;

public class Chatting_room_main extends Activity {

    Button backspace, send;
    ListView chatlist;
    EditText chat;

    ArrayList<ChatMessage> messageItems=new ArrayList<>();
    MyChattingAdapter adapter;

    //disable android back button
    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatting_room_main);

        final String ID, URL = "http://192.168.117.201:8080/Android_Chatting_main";

        backspace = findViewById(R.id.backspace);
        chatlist = findViewById(R.id.chatlist);

        //chatting
        adapter = new MyChattingAdapter(messageItems,getLayoutInflater());
        chatlist.setAdapter(adapter);

        send = findViewById(R.id.send);
        chat = findViewById(R.id.chat);

        //로그인 계정 정보 가져오기
        Intent getintent = getIntent();
        ID = getintent.getStringExtra("id");

        //전송키
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar= Calendar.getInstance(); //현재 시간을 가지고 있는 객체
                String time=calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE); //14:16

                //내 채팅 올라가기
                ChatMessage messageItem= new ChatMessage(ID,chat.getText().toString(),time);

                //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU) ;

                //자기자신 채팅 입력
                //새로운 메세지를 리스뷰에 추가하기 위해 ArrayList에 추가
                messageItems.add(messageItem);

                //리스트뷰를 갱신
                adapter.notifyDataSetChanged();
                chatlist.setSelection(messageItems.size()-1); //리스트뷰의 마지막 위치로 스크롤 위치 이동

                //db전송
                ContentValues contentValues = new ContentValues();
                contentValues.put("ID",messageItem.getID());
                contentValues.put("CHAT",messageItem.getChatList());
                contentValues.put("TIME",messageItem.getTime());

                NetworkTask networkTask = new NetworkTask(URL,contentValues);

                try {
                    networkTask.execute().get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ChatMessage othermessageItem = new ChatMessage("test4", "hi", time);
                messageItems.add(othermessageItem);

                adapter.notifyDataSetChanged();
                chatlist.setSelection(messageItems.size() - 1); //리스트뷰의 마지막 위치로 스크롤 위치 이동

//                //상대방 채팅
//
//
//                //json값에서 String으로 변환하기 이름 시간 채팅 내용
//                JsonToString jsonToString = new JsonToString(otheruser,"ID");
//                otherID = jsonToString.getOtheruser(otheruser, "ID");
//                otherChat = jsonToString.getOtheruser(otheruser, "CHAT");
//
//                //채팅이 비어있지 않으면
//                if(!otherID.equals(ID)) {
//                    //다른사람 채팅 올라가기
//                    ChatMessage othermessageItem = new ChatMessage(otherID, otherChat, time);
//
//                    //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU) ;
//
//                    //자기자신 채팅 입력
//                    //새로운 메세지를 리스뷰에 추가하기 위해 ArrayList에 추가
//                    messageItems.add(othermessageItem);
//
//                    //리스트뷰를 갱신
//                    adapter.notifyDataSetChanged();
//                    chatlist.setSelection(messageItems.size() - 1); //리스트뷰의 마지막 위치로 스크롤 위치 이동
//                }
            }
        });

        //채팅 종료
        backspace.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chatting_room_main.this, Chatting_Matching_Review.class);
                intent.putExtra("id",ID);
                startActivity(intent);
            }
        });
    }
}
