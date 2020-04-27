package com.example.progtech.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.progtech.R;
import com.example.progtech.fragment.HomeFragment;
import com.example.progtech.fragment.SubjectFragment;
import com.example.progtech.fragment.TipsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar_main);
        toolbar.setTitle("home");
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottom_nav_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
                Fragment fragment;
                switch (Item.getItemId()) {
                    case R.id.menu_home:

                        toolbar.setTitle("Home");
                        setSupportActionBar(toolbar);
                        fragment = new HomeFragment();
                        loadFragment(fragment);
                        return true;

                    case R.id.menu_subject:

                        toolbar.setTitle("Subject");
                        setSupportActionBar(toolbar);
                        fragment = new SubjectFragment();
                        loadFragment(fragment);
                        return true;

                    case R.id.menu_tips:

                        toolbar.setTitle("Tips");
                        setSupportActionBar(toolbar);
                        fragment = new TipsFragment();
                        loadFragment(fragment);
                        return true;
                }
                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_main, fragment);
        transaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Cara pertama
        //toolbar.setTitle(R.string.menu_home);
        //setSupportActionBar(toolbar);
        bottomNavigationView.setSelectedItemId(R.id.menu_home);

        //Cara kedua
        //Fragment fragment = new HomeFragment();
        //loadFragment(fragment);
    }

}
