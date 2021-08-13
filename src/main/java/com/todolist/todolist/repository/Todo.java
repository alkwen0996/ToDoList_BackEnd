package com.todolist.todolist.repository;

import com.todolist.todolist.controller.TodoRequest;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Validated
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull(message = "todoSubject column cannot be null")
    private String todoSubject;

    @Column
    @ColumnDefault("false")
    @NotNull(message = "completed column cannot be null")
    private boolean completed = false;

    public int todoId() {
        return id;
    }

    public String todoSubject() {
        return todoSubject;
    }

    public boolean todoCompleted() {
        return completed;
    }

    public Todo(){

    }

    public Todo(Optional<Todo> oldTodo) {
        this.id = oldTodo.get().id;
        this.todoSubject = oldTodo.get().todoSubject;
        this.completed = oldTodo.get().completed;
    }

    public Todo(TodoRequest todoRequest) {
        this.todoSubject = todoRequest.getTodoSubject();
    }

}
