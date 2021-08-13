package com.todolist.todolist.controller;

import com.todolist.todolist.repository.Todo;
import java.util.Optional;

public class TodoResponse {
    private int id;
    private String todoSubject;
    private boolean completed;

    public int getId() {
        return id;
    }

    public String getTodoSubject() {
        return todoSubject;
    }

    public boolean isCompleted() {
        return completed;
    }

    public TodoResponse(Todo newTodo) {
        this.id = newTodo.todoId();
        this.todoSubject = newTodo.todoSubject();
        this.completed = newTodo.todoCompleted();
    }

    public TodoResponse(Optional<Todo> todo) {
        this.id = todo.get().todoId();
        this.todoSubject = todo.get().todoSubject();
        this.completed = todo.get().todoCompleted();
    }
}
