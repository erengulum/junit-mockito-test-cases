package com.testcases.hamcrest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class HamcrestMatchersTest {


    @Test
    public void Test(){
        List<Integer> scores = Arrays.asList(99,100,101,105);

        //scores has four items
        assertThat(scores,hasSize(4));

        //scores has following elements
        assertThat(scores,hasItems(99,100));

        //every item >90
        assertThat(scores,everyItem(greaterThan(90)));

        //some string features
        assertThat("",isEmptyString());
        assertThat(null,isEmptyOrNullString());


        //Arrays
        Integer[] marks = {1,2,3};
        assertThat(marks,arrayWithSize(3));


    }
}
