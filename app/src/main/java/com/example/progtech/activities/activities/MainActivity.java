package com.example.progtech.activities.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.progtech.R;
import com.example.progtech.activities.fragments.HomeFragment;
import com.example.progtech.activities.fragments.SubjectFragment;
import com.example.progtech.activities.fragments.TipsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_main);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.menu_subject:
                            selectedFragment = new SubjectFragment();
                            break;
                        case R.id.menu_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.menu_tips:
                            selectedFragment = new TipsFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, selectedFragment).commit();
                    return true;
                }
            };


}
