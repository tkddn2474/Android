package com.example.ssw;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    //서버 URL 설정
    final static private String URL = "http://3.36.197.241/Register.php";
    private Map<String, String> map;

    public RegisterRequest(String U_id, String U_pw, String U_nick, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("U_id",U_id);
        map.put("U_pw",U_pw);
        map.put("U_nick",U_nick);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
