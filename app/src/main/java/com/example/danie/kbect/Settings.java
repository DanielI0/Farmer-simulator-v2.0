package com.example.danie.kbect;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Settings extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
    }
    public void clearProgress(android.view.View v) {
        MainActivity.core.clearProgress();
    }
    public void changeDifficulty(android.view.View view){

        MainActivity.core.changeDifficulty();
        Toast.makeText(Settings.this,MainActivity.core.getDifficulty(),Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.settings);
    }
}
