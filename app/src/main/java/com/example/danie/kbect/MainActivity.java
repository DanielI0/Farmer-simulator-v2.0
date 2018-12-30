package com.example.danie.kbect;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    //private int FIELD = 1;
   Handler handler;
    realiseIncome a;
    //TextView field = (TextView)findViewById(R.id.Field);
    static Modules core = new Modules();
    @Override
    protected void onPause() {
        super.onPause();
        core.save();
    }

    @Override
    protected void onDestroy() {
        core.save();
        super.onDestroy();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         handler = new Handler() {   // создание хэндлера
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                ((TextView)findViewById(R.id.Field)).setText((String)msg.obj);
                ((TextView)findViewById(R.id.Field)).invalidate();
            }
        };
        if(core.load()!=null){  core = core.load();}
                else core.save();


        final TextView field = (TextView)findViewById(R.id.Field);

            a = new realiseIncome(field);
            a.execute();

            field.setText(core.toString());

    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView field = (TextView)findViewById(R.id.Field);
        field.setText(core.toString());
    }

    public void toShop(android.view.View v){
        Intent i =new Intent(MainActivity.this,ShopActivity.class);

        startActivity(i);

    }
    public void setField(android.view.View view){
        TextView field = (TextView)findViewById(R.id.Field);
        switch (view.getId()){

            case(R.id.ach):

                Intent ach = new Intent(MainActivity.this,Achievements.class);
                startActivity(ach);
                break;
            case(R.id.button):
                Intent set = new Intent(MainActivity.this,Settings.class);
                startActivity(set);
                break;

        }
    }
class realiseIncome extends AsyncTask<Void,Void,Void>{
    TextView field;

    public realiseIncome(TextView field){
        this.field = field;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        int a = 1;

        while(a==1){

            try {
                core.raiseMoney();
                Message msg = Message.obtain();
                msg.obj = core.toString();
                msg.setTarget(handler);
                msg.sendToTarget();

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (RuntimeException e){
                e.printStackTrace();

            }
        }
        return null;
    }


}


}

