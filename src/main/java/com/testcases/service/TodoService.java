package com.testcases.service;

import java.util.List;


//create stub
//start testing by using stub version of TodoService
public interface TodoService {

    public List<String> retrieveTodos(String user);
    public void deleteToDo(String todo);
}
