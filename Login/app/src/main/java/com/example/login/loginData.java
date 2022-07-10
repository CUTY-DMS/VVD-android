package com.example.login;

import android.widget.EditText;

import com.google.gson.annotations.SerializedName;

public class loginData {
    String account_id;
    String password;

    public loginData(String account_id, String password) {
        this.account_id = account_id;
        this.password = password;
    }
}
