package com.example.ssw;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;
import android.view.View;
import android.widget.Button;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.request.SimpleMultiPartRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private Spinner edit_month, edit_gender, edit_email_address;
    private EditText edit_id,edit_pw,edit_nick,edit_rpw,edit_year,edit_name,edit_day,edit_email;
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
        edit_year = findViewById(R.id.edit_year);
        edit_name = findViewById(R.id.edit_name);
        edit_day = findViewById(R.id.edit_day);
        edit_email = findViewById(R.id.edit_email);



        String[] list1 = {"월","1","2","3","4","5","6","7","8","9","10","11","12"};
        String[] list2 = {"성별","남","여"};
        String[] list3 = {"이메일","naver.com","daum.net","gmail.com","net.com"};


        //using ArrayAdapter
        ArrayAdapter spinnerAdapter;
        spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list1);
        edit_month.setAdapter(spinnerAdapter);
        spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list2);
        edit_gender.setAdapter(spinnerAdapter);
        spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list3);
        edit_email_address.setAdapter(spinnerAdapter);


        edit_rpw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus==false){
                    String pass = edit_pw.getText().toString();
                    String repass = edit_rpw.getText().toString();

                    if(pass.equals(repass)){
                        txt_passcheck.setText("비밀번호가 일치합니다");
                    } else{
                        txt_passcheck.setText("비밀번호가 일치하지 않습니다");
                    }
                }
            }
        });


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
                String U_name = edit_name.getText().toString();
                String year = edit_year.getText().toString();
                String month = edit_month.getSelectedItem().toString();
                String day = edit_day.getText().toString();
                String U_birth = year + "0" +month + day;
                String mail = edit_email.getText().toString();
                String domain = edit_email_address.getSelectedItem().toString();
                String U_email = mail + "@" + domain;
                String U_gender = edit_gender.getSelectedItem().toString();
                String URL = "http://3.36.197.241/Register.php";



                SimpleMultiPartRequest smpr= new SimpleMultiPartRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });


                smpr.addStringParam("U_id",U_id);
                smpr.addStringParam("U_pw",U_pw);
                smpr.addStringParam("U_nick",U_nick);
                smpr.addStringParam("U_name",U_name);
                smpr.addStringParam("U_gender",U_gender);
                smpr.addStringParam("U_birth",U_birth);
                smpr.addStringParam("U_email",U_email);

                //요청객체를 서버로 보낼 우체통 같은 객체 생성
                RequestQueue requestQueue= Volley.newRequestQueue(RegisterActivity.this);
                requestQueue.add(smpr);

            }


        });
        
        prevBtnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

    }
}