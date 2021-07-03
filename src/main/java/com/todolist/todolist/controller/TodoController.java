package com.todolist.todolist.controller;

import com.todolist.todolist.repository.Todo;
import com.todolist.todolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private TodoService todoService;

    @GetMapping
    public void getTodos() {
        todoService.selectTodos();
    }

    @PostMapping
    public void insertTodo(@RequestBody Todo todo) {
        todoService.insertTodo(todo);
    }

    @PutMapping("{/todoId}")
    public void updateTodo(@PathVariable("todoId") int todoId){
        todoService.updateTodo(todoId);
    }

    @DeleteMapping("{/todoId}")
    public void deleteTodo(@PathVariable("todoId") int todoId){
        todoService.delete(todoId);
    }
}
