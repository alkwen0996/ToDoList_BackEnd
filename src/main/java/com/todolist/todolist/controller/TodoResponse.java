package com.todolist.todolist.controller;

import com.todolist.todolist.repository.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TodoResponse {
    private Integer id;
    private String todoSubject;
    private boolean completed;

    public TodoResponse(Todo newTodo) {
        this.id = newTodo.getId();
        this.todoSubject = newTodo.getTodoSubject();
        this.completed = newTodo.isCompleted();
    }
}
