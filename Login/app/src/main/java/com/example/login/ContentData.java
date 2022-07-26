package com.example.login;
import java.util.ArrayList;
import java.util.Date;
public class ContentData {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ContentData(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
