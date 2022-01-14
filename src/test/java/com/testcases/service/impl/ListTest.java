package com.testcases.service.impl;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given; //BDD mockito is for Behavior Driven Development
import static org.hamcrest.CoreMatchers.is;

public class ListTest {

    @Test
    public void test_mockListSize(){
        List listMock = mock(List.class); //we mock the list class of the java core
        when(listMock.size()).thenReturn(2);

        assertEquals(2,listMock.size());
    }

    @Test
    public void test_mockListSize_returnMultipleValues(){
        List listMock = mock(List.class); //we mock the list class of the java core
        when(listMock.size()).thenReturn(2).thenReturn(3).thenReturn(4); //we return multiple values.On the first size() call it return 2, then on the second call it returns 3 and so on

        assertEquals(2,listMock.size());
        assertEquals(3,listMock.size());
        assertEquals(4,listMock.size()); //three of them will be true
    }

    @Test
    public void test_mockListGet(){
        List listMock = mock(List.class); //we mock the list class of the java core
        when(listMock.get(anyInt())).thenReturn("test-string");
        assertEquals("test-string",listMock.get(0));
        assertEquals("test-string",listMock.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void test_mockListGet_throwAnException(){
        List listMock = mock(List.class); //we mock the list class of the java core
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Problem Occured! Runtime Exc. is on"));
        listMock.get(0);
    }

    @Test
    public void test_mockListGet_BDD(){

        //given-setup
        List<String> listMock = mock(List.class); //we mock the list class of the java core
        given(listMock.get(anyInt())).willReturn("test-string");

        //when -  actual method calls/actions
        String firstOutput = listMock.get(0);
        String secondOutput = listMock.get(0);

        //then - asserts
        assertThat(firstOutput,is("test-string"));
        assertThat(secondOutput,is("test-string"));
    }
}
