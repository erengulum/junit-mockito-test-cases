package com.testcases.service.impl;

import com.testcases.service.TodoService;
import com.testcases.service.TodoServiceStub;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;

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


    //BDD = Behavior Driven Development
    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDDMock(){

        //Given - Setup

        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring MVC","Angular");

        TodoService mockToDoService = mock(TodoService.class); //instead of real service, we will mock it

        given(mockToDoService.retrieveTodos(anyString())).willReturn(todos); //instead of when-thenReturn we use given-willReturn for BDD case ()

        TodoServiceImpl todoServiceImpl = new TodoServiceImpl(mockToDoService);


        //When - specific method calls / Actions
        List<String> filteredTodos= todoServiceImpl.retrieveSpringTodos("Dummy");


        //Then - Asserts
        assertEquals(2,filteredTodos.size());
    }


    //BDD = Behavior Driven Development
    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD(){

        //Given - Setup

        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring MVC","Angular");

        TodoService mockToDoService = mock(TodoService.class); //instead of real service, we will mock it
        given(mockToDoService.retrieveTodos(anyString())).willReturn(todos); //instead of when-thenReturn we use given-willReturn for BDD case ()

        TodoServiceImpl todoServiceImpl = new TodoServiceImpl(mockToDoService);

        //When - specific method calls / Actions
        todoServiceImpl.deleteallTodosNotRelatedToSpring("Dummy");


        //Then - Asserts

        /*
        //ALTERNATIVES
        verify(mockToDoService).deleteToDo("Angular"); //it check if this method called at least once (or more)
        //verify(mockToDoService,times(1)).deleteToDo("Angular"); //it will be called(one-time,once) because parameter("Angular") doesnt contain "Spring" word

        verify(mockToDoService,never()).deleteToDo("Learn Spring MVC"); //so it won't be called never for this parameter
        */

        //instead of mockitos verify method, we can use then method of BDD - more readable
        then(mockToDoService).should().deleteToDo("Angular"); //it check if this method called at least once (or more)
        then(mockToDoService).should(never()).deleteToDo("Learn Spring MVC"); //method should called NEVER


    }


    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture(){

        //ARGUMENT CAPTOR STEPS:

        //Declare an argument Captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);


        //Given - Setup

        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring MVC","Angular");

        TodoService mockToDoService = mock(TodoService.class); //instead of real service, we will mock it
        given(mockToDoService.retrieveTodos(anyString())).willReturn(todos); //instead of when-thenReturn we use given-willReturn for BDD case ()

        TodoServiceImpl todoServiceImpl = new TodoServiceImpl(mockToDoService);

        //When - specific method calls / Actions
        todoServiceImpl.deleteallTodosNotRelatedToSpring("Dummy");


        //Then - Asserts

        then(mockToDoService).should().deleteToDo(stringArgumentCaptor.capture()); //captures the argument
        assertThat(stringArgumentCaptor.getValue(),is("Angular")); //check if argument is equals to expected value(Angular)

    }


    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture_multipleTimes(){

        //ARGUMENT CAPTOR STEPS:

        //Declare an argument Captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);


        //Given - Setup

        List<String> todos = Arrays.asList("Learn MongoDB","Learn Spring MVC","Angular");

        TodoService mockToDoService = mock(TodoService.class); //instead of real service, we will mock it
        given(mockToDoService.retrieveTodos(anyString())).willReturn(todos); //instead of when-thenReturn we use given-willReturn for BDD case ()

        TodoServiceImpl todoServiceImpl = new TodoServiceImpl(mockToDoService);

        //When - specific method calls / Actions
        todoServiceImpl.deleteallTodosNotRelatedToSpring("Dummy");



        //Then - Asserts
        then(mockToDoService).should(times(2)).deleteToDo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(),is(2));

    }



}