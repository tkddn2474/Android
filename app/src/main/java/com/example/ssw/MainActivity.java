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
    String U_id;


    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_Navi);



        intent = getIntent();
        U_id = intent.getStringExtra("U_id");

        frag_home = new Frag_home();
        final Bundle bundle = new Bundle();
        bundle.putString("U_id","ssaa");
        frag_home.setArguments(bundle);

        //main_frame회면으로 바로 이동시켜줌
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new Frag_home()).commit();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.item_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new Frag_home()).commit();
                        break;
                    case R.id.item_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new Frag_search()).commit();
                        break;
                    case R.id.item_chat:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new Frag_chat()).commit();
                        break;
                    case R.id.item_my:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new Frag_my()).commit();
                        break;
                }

                return true;
            }
        });






    }
}