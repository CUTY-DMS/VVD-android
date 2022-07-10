package com.example.login;

public class signupRequest {
    private String account_id,password,name;
    private int age;

    public signupRequest(String account_id, String password, String name, int age) {
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
