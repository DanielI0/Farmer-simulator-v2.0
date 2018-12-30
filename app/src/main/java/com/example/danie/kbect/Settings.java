package com.example.danie.kbect;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Settings extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
    }
    public void clearProgress(android.view.View v) {
        MainActivity.core.clearProgress(v);
    }
    public void changeDifficulty(android.view.View view){
        MainActivity.core.changeDifficulty(view);
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
