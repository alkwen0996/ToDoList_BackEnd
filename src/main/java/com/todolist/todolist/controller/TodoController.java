package com.todolist.todolist.controller;

import com.todolist.todolist.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> selectTodos() {
        return ResponseEntity.ok(todoService.selectTodos());
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<List<TodoResponse>> selectTodo(@PathVariable("todoId") int todoId) {
        return ResponseEntity.ok(todoService.selectTodo(todoId));
    }

    @PostMapping
    public ResponseEntity<TodoResponse> insertTodo(@RequestBody TodoRequest todoRequest) {
        return ResponseEntity.ok(new TodoResponse(todoService.insertTodo(todoRequest)));
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable("todoId") int todoId) {
        return ResponseEntity.ok(new TodoResponse(todoService.updateTodo(todoId)));
    }

    @DeleteMapping("/{todoId}")
  public ResponseEntity<List<TodoResponse>> deleteTodo(@PathVariable("todoId") int todoId) {
        todoService.delete(todoId);
        return ResponseEntity.ok(todoService.selectTodos());
    }
}
