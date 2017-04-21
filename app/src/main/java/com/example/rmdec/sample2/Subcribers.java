package com.example.rmdec.sample2;

/**
 * Created by rmdec on 21/04/17.
 */

public class Subcribers {

    String name;
    int age,id;
    public Subcribers(String name,int id,int age){
        this.setName(name);
        this.setAge(age);
        this.setId(id);
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
