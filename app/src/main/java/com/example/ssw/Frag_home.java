package com.example.ssw;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    Button btn1;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag_home, container, false);

        context = container.getContext();
        btn1 = v.findViewById(R.id.btn_Write);


        Bundle bundle = getArguments();

        String U_id = bundle.getString("U_id");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Writing.class);
                intent.putExtra("U_id",U_id);
                startActivity(intent);
            }
        });

//
        return v;
    }
}
