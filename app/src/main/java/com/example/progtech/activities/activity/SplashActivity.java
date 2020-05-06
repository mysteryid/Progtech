package com.example.progtech.activities.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.progtech.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread() {
            public void run(){
                try{
                    sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashActivity.this, com.example.progtech.activities.activity.MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
