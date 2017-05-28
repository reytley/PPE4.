package com.example.guest.testppe4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import  android.os.Handler;

public class spashscreen extends AppCompatActivity {

    private static  int splash_Time_out = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myIntent2);

            }
        },splash_Time_out);

    }
}
