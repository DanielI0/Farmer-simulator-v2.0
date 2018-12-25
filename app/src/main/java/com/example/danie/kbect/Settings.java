package com.example.danie.kbect;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Settings extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
    }

    @Override
    protected void onStart() {
        super.onStart();

        setContentView(R.layout.settings);
    }
    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.settings);
    }
}
