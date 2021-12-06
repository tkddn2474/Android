package com.example.ssw;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Check_nick extends StringRequest {

    //서버 URL 설정
    final static private String URL = "http://3.36.197.241/Check_nick.php";
    private Map<String, String> map;

    public Check_nick(String U_nick, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("U_nick",U_nick);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
