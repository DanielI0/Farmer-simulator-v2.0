package com.example.danie.kbect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Achievements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        TextView a = (TextView)findViewById(R.id.Achievements);
        a.setText(

                "Uncompleted:\n"
                        +MainActivity.core.checkUnAch()+
                        "Completed:\n"+
                        MainActivity.core.checkComplAch()
        );
    }
}
