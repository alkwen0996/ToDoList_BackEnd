package com.todolist.todolist.repository;

import com.sun.istack.NotNull;
import com.todolist.todolist.controller.TodoRequest;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull
    private String todoSubject;

    @Column
    @ColumnDefault("false")
    @NotNull
    private boolean completed = false;

    public Todo() {
    }

    public Todo(Optional<Todo> oldTodo) {
        this.id = oldTodo.get().getId();
        this.todoSubject = oldTodo.get().getTodoSubject();
        this.completed = true;
    }

    public Todo(TodoRequest todoRequest) {
        this.todoSubject = todoRequest.getTodoSubject();
    }

    public int getId() {
        return id;
    }

    public String getTodoSubject() {
        return todoSubject;
    }

    public boolean isCompleted() {
        return completed;
    }
}
