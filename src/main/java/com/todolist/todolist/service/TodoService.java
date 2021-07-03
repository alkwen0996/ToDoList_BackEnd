package com.todolist.todolist.service;

import com.todolist.todolist.repository.Todo;
import com.todolist.todolist.repository.TodoRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class TodoService {
    private TodoRepository todoRepository;


    public void selectTodos() {
        todoRepository.findAll();
    }

    public void insertTodo(Todo todo) {
        Todo newTodo = new Todo(todo);
        todoRepository.save(newTodo);
    }

    public void updateTodo(int todoId) {
        if (todoRepository.findById(todoId).isEmpty()) {
            try {
                throw new NotFoundException(todoId + "not found");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }

        Optional<Todo> oldTodo = todoRepository.findById(todoId);
        Todo newTodo = new Todo(oldTodo);
        todoRepository.save(newTodo);
    }

    public void delete(int todoId) {
        if (todoRepository.findById(todoId).isPresent()) {
            todoRepository.deleteById(todoId);
        }
    }
}
