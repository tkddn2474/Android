package com.example.ssw;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class WritingRequest extends StringRequest {

    final static private String URL = "http://3.36.197.241/Board_write.php";
    private Map<String, String> map;

    public WritingRequest(String U_id,String B_content,String B_title,String B_photo,Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("U_id",U_id);
        map.put("B_photo",B_photo);
        // map.put("B_price",B_price);
        map.put("B_content",B_content);
        map.put("B_title",B_title);
        //map.put("B_cate",B_cate);


    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}

