package com.example.danie.kbect;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Modules  extends AppCompatActivity
        implements Serializable{

    static final int KEY = 12819;
    private short difficulty = 2;

    long s = 10;
    long money = 1000;
    short mastership = 1;
    File root, file;


    public long calculateIncome() {return s*mastership*difficulty/2;}

    public Modules(){
        root = new File(Environment.getExternalStorageDirectory(),"FarmerSimulator");
        if(!root.exists()) root.mkdir();
        file = new File(root,"SaveFromSim.txt");

    }

    @Override
    public String toString() {
        return "Area: "+s+"\nMoney: "+money+"\nMastership level: "+mastership+"\nIncome: "+calculateIncome();
    }

    //Settings

    public void changeDifficulty(android.view.View view) {

        difficulty = (difficulty == 3) ? 1:(short)(difficulty+1);
    }

    public short getDifficulty() {
        return difficulty;
    }

    public void clearProgress(android.view.View view){
        file.delete();
    }

    //File saving
    public Modules load(){
        try{
            FileInputStream in = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(in);
            return (Modules) ois.readObject();
        }catch (IOException e){

        }catch (ClassNotFoundException e){

        }
        return null;
    }
    public void save(){
        try{

            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(this);
            out.close();
            oos.close();

        }catch (IOException e){
            e.printStackTrace();
            money = 1000000000;
        }
    }

    //Shop activity
    void buyS(Context a){
        if(money>=100000) {
            s += 5000;
            money -= 100000;
        }else{
            Toast.makeText(a,"Not enough money",Toast.LENGTH_LONG);
        }
    }
    void upMasterShipLVL(){
        mastership+=1;
        money-=1000000;
    }
    void raiseMoney(){
        money+=calculateIncome();
    }

    //Achievements

    String checkUnAch(){
        return (money<1000000000 ? "   Become dollar billioner\n":"")+(s<150000000 ? "  Seize The Earth":"");
    }
    String checkComplAch(){
        return (money>=1000000000 ? "   Become dollar billioner\n":"")+(s>=150000000 ? "  Seize The Earth":"");
    }



}
