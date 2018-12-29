package com.example.danie.kbect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    //private int FIELD = 1;
    String s = getApplicationContext().getFilesDir()+"SaveFromQuest.sfq";
    static Modules core = new Modules();
    @Override
    protected void onPause() {
        super.onPause();
        core.save();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        core = core.load();






    }

    public void toShop(android.view.View v){
        Intent i =new Intent(MainActivity.this,ShopActivity.class);

        startActivity(i);

    }
    public void setField(android.view.View view){
        TextView field = (TextView)findViewById(R.id.Field);
        switch (view.getId()){
            case(R.id.farm):

                field.setText(core.toString());

                break;
            case(R.id.ach):
                field.setText(
                        "Uncompleted:\n"
                        +core.checkUnAch()+
                        "Completed:\n"+
                        core.checkComplAch()
                );
                break;

        }
    }



}

