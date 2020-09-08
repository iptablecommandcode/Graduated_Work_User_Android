//Connect to chatting_main in listview

package com.example.graduated_work_user_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class Chatting_room_adapter extends ArrayAdapter {

    List msgs = new ArrayList();

    public Chatting_room_adapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public void add(Chatting_room_adapter object){

        msgs.add(object);
        super.add(object);
    }

    @Override

    public int getCount() {
        return msgs.size();
    }

    @Override

    public Chatting_room_adapter getItem(int index) {
        return (Chatting_room_adapter) msgs.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.chatting_room_main, parent, false);
        }

        Chatting_room_adapter msg = (Chatting_room_adapter) msgs.get(position);
        TextView msgText = (TextView) row.findViewById(R.id.ch); // 수정
        msgText.setText(msg.getMessage()); // 수정

        return row;

    }
}


