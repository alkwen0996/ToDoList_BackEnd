package com.todolist.todolist.controller;

import com.todolist.todolist.repository.Todo;
import com.todolist.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<Iterable<Todo>> selectTodos() {
        Iterable<Todo> list = todoService.selectTodos();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<TodoResponse> insertTodo(@RequestBody TodoRequest todoRequest) {
        Todo newTodo = todoService.insertTodo(todoRequest);
        return ResponseEntity.ok(new TodoResponse(newTodo));
    }

    @PutMapping("/update/{todoId}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable("todoId") int todoId) {
        Todo newTodo = todoService.updateTodo(todoId);
        return ResponseEntity.ok(new TodoResponse(newTodo));
    }

    @DeleteMapping("/delete/{todoId}")
    public ResponseEntity<Iterable<Todo>> deleteTodo(@PathVariable("todoId") int todoId) {
        todoService.delete(todoId);
        Iterable<Todo> list = todoService.selectTodos();
        return ResponseEntity.ok(list);
    }
}
