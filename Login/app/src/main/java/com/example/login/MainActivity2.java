package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.login.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentManager fragmentManager;
    private mypage mypage;
    private reminder search;
    private add home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fragmentManager = getSupportFragmentManager();
        Fragment mypage = new mypage();
        Fragment search = new reminder();
        Fragment home = new add();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                int id = item.getItemId();

                switch (id) {
                    case R.id.i1:
                        transaction.replace(R.id.frame_layout, mypage).commitAllowingStateLoss();
                        break;
                    case R.id.i2:
                        transaction.replace(R.id.frame_layout, search).commitAllowingStateLoss();
                        break;
                    case R.id.i3:
                        transaction.replace(R.id.frame_layout, home).commitAllowingStateLoss();
                        break;
                }
                return true;
            }
        });
    }

}