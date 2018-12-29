package com.example.danie.kbect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        //String result = getIntent().getStringExtra("data");

        Button s = (Button)findViewById(R.id.buyS);
        Button l = (Button)findViewById(R.id.upSeedLVL);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.core.buyS();
            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.core.upMasterShipLVL();
            }
        });
    }
}
