package com.example.ssw;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Frag_chat extends Fragment {

    private ArrayList<ChatListData> arrayList;
    private ChatListData chatListData;
    private ChatListAdapter chatListAdapter;
    private ListView listView;
    private static Context context;
    String U_id;
    Bundle bundle;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag_chat, container, false);
        context = container.getContext();

        listView = v.findViewById(R.id.lv);

        arrayList = new ArrayList<ChatListData>();



        bundle = getArguments();
        U_id = bundle.getString("U_id");



        //이제 response로 데이터값 받아서 뿌려주기만 하면됨
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("post");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject item = jsonArray.getJSONObject(i);
                        String Chat_nickname = item.getString("Post_nickname");
                        chatListData = new ChatListData(Chat_nickname);
                        arrayList.add(chatListData);
                    }

                    chatListAdapter = new ChatListAdapter(context,arrayList);
                    listView.setAdapter(chatListAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        };

        ChatListReguest chatListReguest = new ChatListReguest(U_id,responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(chatListReguest);

        return v;
    }
}
