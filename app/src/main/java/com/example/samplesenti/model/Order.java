package com.example.samplesenti.model;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.io.Serializable;


public class Order implements Serializable {
    public int getCounnt() {
        return counnt;
    }

    public void setCounnt(int counnt) {
        this.counnt = counnt;
    }

    private  int counnt;
    private String price,name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public Order( String price, String name){
        this.price = price;
        this.name = name;
    }

}
