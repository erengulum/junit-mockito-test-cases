package com.testcases;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;

@Slf4j
public class QuickBeforeAfterTest {

    @BeforeClass
    public static void beforeClass(){ //will be executed only once, at the beginning, it has to be static
        System.out.println("Before class- executed");
    }


    @Before
    public void testSetup(){ //we want to execute this method beofre each test
        System.out.println("Before: Test setup is created");
    }

    @Test
    public void test1(){
        System.out.println("Test1 executed");
    }

    @Test
    public void test2(){
        System.out.println("Test2 executed");
    }

    @After
    public void tearDown(){ //we want to execute this method beofre tests
        System.out.println("After: Teardown  is created");
    }

    @AfterClass
    public static void afterClass(){ //will be executed only once, at the end, it has to be static
        System.out.println("After class- executed");
    }
}
