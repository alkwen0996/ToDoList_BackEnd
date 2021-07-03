package com.todolist.todolist.controller;

import lombok.Data;

@Data
public class TodoRequest {
    private String todoName;

    public TodoRequest(String todoName) {
        this.todoName = todoName;
    }
}
