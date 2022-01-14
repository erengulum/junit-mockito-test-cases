package com.testcases.service;

import java.util.Arrays;
import java.util.List;

//Stub: Dummy impl
public class TodoServiceStub implements TodoService {


    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC","Learn Spring MVC","Angular");
    }
}
