package com.example.login;

import java.util.ArrayList;

public class reminderData {
    private ArrayList<TodoDetailRespons> List;

    public reminderData(ArrayList<TodoDetailRespons> list) {
        List = list;
    }

    public ArrayList<TodoDetailRespons> getList() {
        return List;
    }
}
