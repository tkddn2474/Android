package com.example.ssw;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

public class Frag_home extends Fragment {

    BottomNavigationView bottomNavigationView;
    TextView txt_id,txt_pw;
    private String s;
    private static Context context;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag_home, container, false);
        txt_id = v.findViewById(R.id.txt_id);
        txt_pw = v.findViewById(R.id.txt_pw);
        context = container.getContext();

        String id = txt_id.getText().toString();
        String pw = txt_pw.getText().toString();

        Bundle bundle = new Bundle();

        String a = bundle.getString("U_id","0");

        if (getArguments() != null) {
            s = getArguments().getString("U_id");
        }else{
            s = "값이 없어";
        }

        txt_id.setText(a);


        Response.Listener<String> responseListener = new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                    String U_id = jsonObject.getString("U_id");
                    String U_pw = jsonObject.getString("U_pw");
                    Log.d("전돼지", response);
                    Log.d("수환이는 슈퍼 돼지", jsonObject.getString("U_id"));
                    //txt_id.setText(U_id);
                    //txt_pw.setText(U_pw);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
        LoginRequest loginRequest = new LoginRequest("aa","aa",responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(loginRequest);

        Toast.makeText(context, id+pw, Toast.LENGTH_SHORT).show();

        return v;
    }
}
