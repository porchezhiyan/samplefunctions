package com.example.rmdec.sample2;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;


/**
 * Created by rmdec on 21/04/17.
 */

public class Subcribers {

    String name;
    int age,id;
    public Subcribers(Context context,String name, int id, int age){
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        Toast.makeText(context,Integer.toString(age),Toast.LENGTH_LONG).show();

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
