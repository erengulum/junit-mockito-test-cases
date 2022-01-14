package com.testcases.service.impl;

import com.testcases.service.TodoService;
import com.testcases.service.TodoServiceStub;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
public class TodoServiceImplMockTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock(){

        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring MVC","Angular");

        TodoService mockToDoService = mock(TodoService.class); //instead of real service, we will mock it
        when (mockToDoService.retrieveTodos(anyString())).thenReturn(todos); //no we mocked the service implementation


        TodoServiceImpl todoServiceImpl = new TodoServiceImpl(mockToDoService);
        List<String> filteredTodos= todoServiceImpl.retrieveSpringTodos("Dummy");
        assertEquals(2,filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_withEmptyList(){

        List<String> todos = Arrays.asList(); //empty list

        TodoService mockToDoService = mock(TodoService.class); //instead of real service, we will mock it
        when (mockToDoService.retrieveTodos(anyString())).thenReturn(todos); //return a empty lisy

        TodoServiceImpl todoServiceImpl = new TodoServiceImpl(mockToDoService);
        List<String> filteredTodos= todoServiceImpl.retrieveSpringTodos("Dummy");
        assertEquals(0,filteredTodos.size()); //since it's empty lsti, expected value should be 0
    }


}