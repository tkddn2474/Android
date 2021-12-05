package com.example.ssw;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatListAdapter extends BaseAdapter {

    Context context;
    ArrayList<ChatListData> chatData;

    public ChatListAdapter(Context context, ArrayList<ChatListData> chatData) {
        this.context = context;
        this.chatData = chatData;
    }


    @Override
    public int getCount() {
        return chatData.size();
    }

    @Override
    public Object getItem(int i) {
        return chatData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null) {
            view = View.inflate(context, R.layout.chatlist_item,null);
        }

        TextView txt_nickname = view.findViewById(R.id.txt_nickname);

        txt_nickname.setText(chatData.get(i).txt_nickname);


        return view;
    }
}
