package com.example.login;

import java.util.ArrayList;

public class mypageData {
    private String name;
    private int age;
    private ArrayList<listData> List;

    public mypageData(String name, int age, ArrayList<listData> list) {
        this.name = name;
        this.age = age;
        List = list;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<listData> getList() {
        return List;
    }
}
