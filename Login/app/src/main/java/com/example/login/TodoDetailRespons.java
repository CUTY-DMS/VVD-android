package com.example.login;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TodoDetailRespons {
    Long todoId;
    String title,content;
    LocalDateTime dateTime;
    boolean completed,liked;

    public TodoDetailRespons(Long todoId, String title, String content, LocalDateTime dateTime, boolean completed, boolean liked) {
        this.todoId = todoId;
        this.title = title;
        this.content = content;
        this.dateTime = dateTime;
        this.completed = completed;
        this.liked = liked;
    }

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
}
