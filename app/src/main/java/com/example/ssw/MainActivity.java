package com.example.ssw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Frag_home frag_home;
    Frag_chat frag_chat;
    Frag_my frag_my;
    Frag_search frag_search;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_Navi);
        frag_home= new Frag_home();
        frag_chat = new Frag_chat();
        frag_my = new Frag_my();
        frag_search = new Frag_search();

        intent = getIntent();
        String U_id = intent.getStringExtra("U_id");

        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,frag_home).commit();
        //main_frame회면으로 바로 이동시켜줌
        Bundle bundle = new Bundle();
        bundle.putString("U_id",U_id);
        frag_home.setArguments(bundle);
        frag_chat.setArguments(bundle);




        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.item_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,frag_home).commit();
                        break;
                    case R.id.item_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,frag_search).commit();
                        break;
                    case R.id.item_chat:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,frag_chat).commit();
                        break;
                    case R.id.item_my:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,frag_my).commit();
                        break;
                }

                return true;
            }

        });


    }
}