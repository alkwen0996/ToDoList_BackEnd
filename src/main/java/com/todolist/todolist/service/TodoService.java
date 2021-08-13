package com.todolist.todolist.service;

import com.todolist.todolist.controller.TodoRequest;
import com.todolist.todolist.controller.TodoResponse;
import com.todolist.todolist.repository.Todo;
import com.todolist.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Transactional
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoResponse> selectTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(TodoResponse::new).collect(Collectors.toList());
    }

    public List<TodoResponse> selectTodo(int todoId) {
        Optional<Todo> todo = todoRepository.findById(todoId);
        return todo.stream().map(TodoResponse::new).collect(Collectors.toList());
    }

    public Todo insertTodo(TodoRequest todoRequest) {
        Todo newTodo = new Todo(todoRequest);
        todoRepository.save(newTodo);
        return newTodo;
    }

    public Todo updateTodo(int todoId) {
        Optional<Todo> oldTodo = todoRepository.findById(todoId);
        Todo newTodos = new Todo(oldTodo);
        todoRepository.save(newTodos);

        return newTodos;
    }

    public void delete(int todoId) {
        if (todoRepository.findById(todoId).isPresent()) {
            todoRepository.deleteById(todoId);
        }
    }
}
