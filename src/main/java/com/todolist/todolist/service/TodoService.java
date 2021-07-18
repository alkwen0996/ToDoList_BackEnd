package com.todolist.todolist.service;

import com.todolist.todolist.controller.TodoRequest;
import com.todolist.todolist.repository.Todo;
import com.todolist.todolist.repository.TodoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Iterable<Todo> selectTodos() {
        return todoRepository.findAll();
    }

    public Todo insertTodo(TodoRequest todoRequest) {
        Todo newTodo = new Todo(todoRequest);
        todoRepository.save(newTodo);
        return newTodo;
    }

    public Todo updateTodo(int todoId) {
        if (todoRepository.findById(todoId).isEmpty()) {
            try {
                throw new NotFoundException(todoId + " not found");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }

        Optional<Todo> oldTodo = todoRepository.findById(todoId);
        Todo newTodo = new Todo(oldTodo);
        todoRepository.save(newTodo);
        return newTodo;
    }

    public void delete(int todoId) {
        if (todoRepository.findById(todoId).isPresent()) {
            todoRepository.deleteById(todoId);
        }
    }
}
