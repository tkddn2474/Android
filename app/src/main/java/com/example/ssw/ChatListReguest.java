package com.example.ssw;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatListReguest extends StringRequest {

    //서버 URL 설정
    final static private String URL = "http://3.36.197.241/ChatList.php";
    private Map<String, String> map;

    public ChatListReguest(String U_id,Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("U_id",U_id);


    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
