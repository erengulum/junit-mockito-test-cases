package com.testcases.service.impl;

import com.testcases.service.TodoService;

import java.util.ArrayList;
import java.util.List;

public class TodoServiceImpl {

    private TodoService todoService;//we will mock this interface


    public TodoServiceImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveSpringTodos(String user){
        List<String> filteredTodos = new ArrayList<String>();
        List<String> todos = todoService.retrieveTodos(user);
        for (String todo : todos) {
            if(todo.contains("Spring"))
                filteredTodos.add(todo);

        }


        return filteredTodos;
    }

}
