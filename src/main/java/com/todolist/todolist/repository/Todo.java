package com.todolist.todolist.repository;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "TODO")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String todoSubject;

    @Column(nullable = false)
    private String createdDate;

    @Column(nullable = false)
    private String dueDate;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean completed = false;

}
