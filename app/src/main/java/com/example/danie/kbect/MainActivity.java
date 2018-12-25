package com.example.danie.kbect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    String s = getApplicationContext().getFilesDir()+"SaveFromQuest.sfq";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Modules m = new Modules(s);
        Button b = (Button)findViewById(R.id.button);
        TextView fromFile = (TextView)findViewById(R.id.text);
        fromFile.setText(m.loadProgress().toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent set = new Intent(MainActivity.this,Settings.class);
                startActivity(set);

            }
        });
    }




}

