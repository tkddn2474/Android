package com.example.ssw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private Spinner edit_month, edit_gender, edit_email_address;
    private EditText edit_id,edit_pw,edit_nick,edit_rpw;
    private TextView txt_passcheck,txt_nickcheck;
    private Button btn_register, prevBtnJoin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edit_id = findViewById(R.id.edit_id);
        edit_pw = findViewById(R.id.edit_pw);
        edit_rpw = findViewById(R.id.edit_rpw);
        edit_nick = findViewById(R.id.edit_nick);
        txt_nickcheck = findViewById(R.id.txt_nickcheck);
        txt_passcheck = findViewById(R.id.txt_passcheck);
        prevBtnJoin = findViewById(R.id.prevBtnJoin);


        edit_month = (Spinner)findViewById(R.id.edit_month);
        edit_gender = (Spinner)findViewById(R.id.edit_gender);
        edit_email_address = (Spinner)findViewById(R.id.edit_email_address);

        //input array data
        /*final ArrayList<Integer> list1 = new ArrayList<>();
        for(int i = 1; i < 13; i++ ) {
            list1.add(i);
        }*/

        String[] list1 = new String[13];
        list1[0] = "월";
        list1[1] = "1";
        list1[2] = "2";
        list1[3] = "3";
        list1[4] = "4";
        list1[5] = "5";
        list1[6] = "6";
        list1[7] = "7";
        list1[8] = "8";
        list1[9] = "9";
        list1[10] = "10";
        list1[11] = "11";
        list1[12] = "12";


        //input array data
        String[] list2 = new String[3];
        list2[0] = "성별";
        list2[1] = "남";
        list2[2] = "여";

        String[] list3 = new String[4];
        list3[0] = "naver.com";
        list3[1] = "daum.net";
        list3[2] = "gmail.com";
        list3[3] = "net.com";

        
        /*
        String[] list2 = new String[2];
        list2[0] = "안녕";
        list2[1] = "하세요";
        */

        //using ArrayAdapter
        ArrayAdapter spinnerAdapter;
        spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list1);
        edit_month.setAdapter(spinnerAdapter);
        spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list2);
        edit_gender.setAdapter(spinnerAdapter);
        spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list3);
        edit_email_address.setAdapter(spinnerAdapter);

        /*
        edit_pw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus==false){
                    String pass = edit_pw.getText().toString();
                    String repass = edit_rpw.getText().toString();
                    if(pass.equals(repass)){
                        txt_passcheck.setText("비밀번호가 일치합니다");
                    } else{
                        txt_nickcheck.setText("비밀번호가 일치하지 않습니다");
                    }

                }
            }
        });

        */


        prevBtnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String U_id = edit_id.getText().toString();
                String U_pw = edit_pw.getText().toString();
                String U_nick = edit_nick.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success) {
                                Toast.makeText(getApplicationContext(), "회원 등록 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(getApplicationContext(), "회원 등록 실패", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(U_id,U_pw,U_nick,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);


            }
        });


    }
}