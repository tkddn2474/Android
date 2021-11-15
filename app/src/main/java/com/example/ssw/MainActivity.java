package com.example.ssw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_Navi);

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