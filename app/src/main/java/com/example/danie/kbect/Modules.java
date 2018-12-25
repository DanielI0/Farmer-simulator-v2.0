package com.example.danie.kbect;

import android.support.annotation.RequiresPermission;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Modules {
    final int K=10;
    private int koeff = K;
    static char[] data = {'1',' ','2',' ','P'};

    FileOutputStream put;
    FileInputStream get;
    public Modules(String s){
        try {
            FileOutputStream put = new FileOutputStream(s);
            FileInputStream get = new FileInputStream(s);
            this.get = get;
            this.put = put;
        }catch (FileNotFoundException e){

        }
    }
    private void switchReplic(){

    }
    protected void saveProgress(){

    }
    protected char[] loadProgress(){
        decode();
        char[] lll = data.clone();
        codify();
        return lll;
    }
    private void decode(){
        for(int i=0; i<100;i++){
            try {
                data[i]=(char)get.read();
                data[i]-=10;
                koeff^=data[i];
                data[i]=(char)koeff;
                koeff = K;
            }catch (IOException e){
                Log.d("SSSs","IO");
            }
        }
    }
    private void codify(){
        for(int i=0;i<100;i++){
            data[i]^=koeff;
            data[i]+=10;
            try {
                put.write(data[i]);
            }catch (IOException e){

            }
        }
    }
}
