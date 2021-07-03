package com.todolist.todolist.repository;

import com.todolist.todolist.controller.TodoRequest;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Data
@Entity
@Table(name = "TODO")
public class Todo {
    private TodoRequest todoRequest;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String todoSubject;

    @Column
    private String todoContent;

    @Column(nullable = false)
    @CreatedDate
    private Date createdDate;

    @Column(nullable = false)
    private Date dueDate;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean completed = false;

    public Todo(String todoSubject) {
        this.todoSubject = todoSubject;
    }

    public Todo(boolean completed) {
        this.completed = completed;
    }

    public Todo(String todoSubject, String todoContent, Date createdDate, Date dueDate, boolean completed) {
        this.todoSubject = todoSubject;
        this.todoContent = todoContent;
        this.createdDate = createdDate;
        this.dueDate = dueDate;
        this.completed = false;
    }

    public Todo() {
        
    }

    public Todo(Todo todo) {

    }

    public Todo(Optional<Todo> oldTodo) {

    }

    public Todo Todo(final Optional<Todo> oldTodo) {
        return new Todo(true);
    }
}
