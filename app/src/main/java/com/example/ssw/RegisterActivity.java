package com.example.ssw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText edit_id,edit_pw,edit_nick,edit_rpw;
    private TextView txt_passcheck,txt_nickcheck;
    private Button btn_register;
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