package com.example.login;

import android.widget.EditText;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class signupData {

    private String account_id;
    private String password;
    private String name;
    private int age;

    public signupData(String account_id, String password, String name, int age) {
        this.account_id = account_id;
        this.password = password;
        this.name = name;
        this.age = age;
    }


    public String getAccount_id() {
        return account_id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
