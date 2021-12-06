package com.example.ssw;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class testRequset extends StringRequest {

    //서버 URL 설정
    final static private String URL = "http://3.36.197.241/Login.php";
    private Map<String, String> map;

    public testRequset(String U_id, String U_pw, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("U_id",U_id);
        map.put("U_pw",U_pw);
    }


    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}

