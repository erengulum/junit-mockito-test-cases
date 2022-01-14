package com.testcases;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.spy;

public class SpyTest {

    @Test
    public void test_mock(){
        List arrayListmocked = mock(ArrayList.class);
        when(arrayListmocked.size()).thenReturn(5);
        assertEquals(5,arrayListmocked.size());
        arrayListmocked.add("Dummy"); //even though we added a new element, it won't return 6. Totally mocked&manipulated. There is no real ArrayList object.
        assertEquals(5,arrayListmocked.size());
    }

    @Test
    public void test_spy_real(){
        /*mocktan farkı: direkt objeyi mocklamıyor. Objenin bütün fonklarını kullanıp bir kısmını da mockdaki gibi manipüle edebiliyorsun.
        "spy" will create REAL ARRAYLIST.But you can manipulate any functionality of this real object */
        List arrayListspied = spy(ArrayList.class);
        //we don't use when-then func for now. It is a real object. But we can use it for manipulation
        assertEquals(0,arrayListspied.size());
        arrayListspied.add("Dummy");
        assertEquals(1,arrayListspied.size());
    }


    @Test
    public void test_spy_manipulate(){
        //mocktan farkı: direkt objeyi mocklamıyor. Objenin bütün fonklarını kullanıp bir kısmını da mockdaki gibi manipüle edebiliyorsun.
        //"spy" will create REAL ARRAYLIST.But you can manipulate any functionality of this real object
        List arrayListspied = spy(ArrayList.class);
        when(arrayListspied.size()).thenReturn(5);
        assertEquals(5,arrayListspied.size());
        arrayListspied.add("Dummy"); //since size() method is manipualted.It will always resturn 5
        assertEquals(5,arrayListspied.size());
    }


}
