package com.example.login;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class listData {
    String title,content,name;
    LocalDateTime dateTime;
    boolean completed,liked;

    public listData(String title, String content,String name,LocalDateTime dateTime, boolean completed,boolean liked) {
        this.title = title;
        this.content = content;
        this.name = name;
        this.dateTime = dateTime;
        this.completed = completed;
        this.liked = liked;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isLiked() {
        return liked;
    }
}
