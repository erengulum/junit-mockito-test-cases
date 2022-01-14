package com.testcases.service.impl;

import com.testcases.service.TodoService;
import com.testcases.service.TodoServiceStub;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class TodoServiceImplStubTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAStub(){
        TodoService todoServiceStub = new TodoServiceStub(); //instead of real service, we will use stub
        TodoServiceImpl todoServiceImpl = new TodoServiceImpl(todoServiceStub);

        List<String> filteredTodos= todoServiceImpl.retrieveSpringTodos("Dummy User");

        assertEquals(2,filteredTodos.size());
    }


}