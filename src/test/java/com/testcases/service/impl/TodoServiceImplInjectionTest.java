package com.testcases.service.impl;

import com.testcases.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;

@Slf4j
//@RunWith(MockitoJUnitRunner.class) /instead of this we use Rule below(MockitoJUnit.rule();)
public class TodoServiceImplInjectionTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule(); //all rules have to be public

    @Mock
    TodoService mockToDoService; //automatically create moch of service


    @InjectMocks //serviceImpl'in todoservice injection'a ihtiyacı vardı. Annotation sayesinde direkt gereken mockları injectliyor(tabi önce yukarıda mocklaman lazım)
    TodoServiceImpl todoServiceImpl;


    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;


    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock(){

        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring MVC","Angular");

        when (mockToDoService.retrieveTodos(anyString())).thenReturn(todos); //no we mocked the service implementation


        List<String> filteredTodos= todoServiceImpl.retrieveSpringTodos("Dummy");
        assertEquals(2,filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_withEmptyList(){

        List<String> todos = Arrays.asList(); //empty list

        when (mockToDoService.retrieveTodos(anyString())).thenReturn(todos); //return a empty lisy

        List<String> filteredTodos= todoServiceImpl.retrieveSpringTodos("Dummy");
        assertEquals(0,filteredTodos.size()); //since it's empty lsti, expected value should be 0
    }


    //BDD = Behavior Driven Development
    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDDMock(){

        //Given - Setup

        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring MVC","Angular");


        given(mockToDoService.retrieveTodos(anyString())).willReturn(todos); //instead of when-thenReturn we use given-willReturn for BDD case ()



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

        given(mockToDoService.retrieveTodos(anyString())).willReturn(todos); //instead of when-thenReturn we use given-willReturn for BDD case ()


        //When - specific method calls / Actions
        todoServiceImpl.deleteallTodosNotRelatedToSpring("Dummy");


        //Then
        then(mockToDoService).should().deleteToDo("Angular"); //it check if this method called at least once (or more)
        then(mockToDoService).should(never()).deleteToDo("Learn Spring MVC"); //method should called NEVER


    }


    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture(){


        //Given - Setup

        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring MVC","Angular");

        given(mockToDoService.retrieveTodos(anyString())).willReturn(todos); //instead of when-thenReturn we use given-willReturn for BDD case ()


        //When - specific method calls / Actions
        todoServiceImpl.deleteallTodosNotRelatedToSpring("Dummy");


        //Then - Asserts

        then(mockToDoService).should().deleteToDo(stringArgumentCaptor.capture()); //captures the argument
        assertThat(stringArgumentCaptor.getValue(),is("Angular")); //check if argument is equals to expected value(Angular)

    }


    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture_multipleTimes(){


        //Given - Setup

        List<String> todos = Arrays.asList("Learn MongoDB","Learn Spring MVC","Angular");
        given(mockToDoService.retrieveTodos(anyString())).willReturn(todos); //instead of when-thenReturn we use given-willReturn for BDD case ()


        //When - specific method calls / Actions
        todoServiceImpl.deleteallTodosNotRelatedToSpring("Dummy");

        //Then - Asserts
        then(mockToDoService).should(times(2)).deleteToDo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(),is(2));

    }



}