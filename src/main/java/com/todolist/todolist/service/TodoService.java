package com.todolist.todolist.service;

import com.todolist.todolist.repository.Todo;
import com.todolist.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class TodoService{
    private TodoRepository todoRepository;
    private Todo todo;

    public Iterable<Todo> selectTodos(){
        return todoRepository.findAll();
    }

    public void insertTodo(String todoName){
        todoRepository.save(todo);
    }

    public Todo updateTodo(int todoId){
        if(todoRepository.findById(todoId).equals(null)){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        todo.setCompleted(!todo.isCompleted());
        return todoRepository.save(todo);
    }

    public void delete(int todoId){
        if(!todoRepository.findById(todoId).equals(null)){
            todoRepository.deleteById(todoId);
        }
    }
}
