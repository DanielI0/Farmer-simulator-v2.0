package com.example.danie.kbect;

import android.support.annotation.RequiresPermission;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Modules implements Serializable {
    static final int KEY = 12819;
    long s = 10;//m^2
    long money = 1000;
    short mastership = 1;


    @Override
    public String toString() {
        return "Area: "+s+"\nMoney: "+money+"\nMastership level: "+mastership+"\n";
    }
    public static Modules load(){
        try{
            FileInputStream in = new FileInputStream("savFromSim.ld");
            ObjectInputStream ois = new ObjectInputStream(in);
            return (Modules) ois.readObject();
        }catch (IOException e){

        }catch (ClassNotFoundException e){

        }
        return null;
    }
    public void save(){
        try{
            FileOutputStream out = new FileOutputStream("savFromSim.ld");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(this);
            oos.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    void buyS(){
        s+=1000;
        money-=100000;
    }
    void upMasterShipLVL(){
        mastership+=1;
        money-=1000;
    }
    String checkUnAch(){
        return (money<1000000000 ? "   Become dollar billioner\n":"")+(s<150000000 ? "  Seize The Earth":"");
    }
    String checkComplAch(){
        return (money>=1000000000 ? "   Become dollar billioner\n":"")+(s>=150000000 ? "  Seize The Earth":"");
    }



}
