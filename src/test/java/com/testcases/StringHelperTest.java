package com.testcases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {


    StringHelper stringHelper = new StringHelper();


    //all unit tests should be public and void, otherwise it wont work
    @Test
    public void testTruncateAInFirst2Positions_AinFirstPosition(){

        assertEquals("CD", stringHelper.truncateAInFirst2Positions("ACD"));

    }


    @Test
    public void testTruncateAInFirst2Positions_AinFirst2Position() {
        assertEquals("CD", stringHelper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions_NoAinFirstPosition() {
        assertEquals("CCCD", stringHelper.truncateAInFirst2Positions("CCCD"));
    }


    //ABCD =>false   ABAB=>true  AB=>true  A=>false
    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario(){
        assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("ABCD")); //if the return value is NOT false(assertFalse), it throws a aassert
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario(){
        assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("ABAB")); //if the return value is NOT TRUE (assertTrue), it throws a failure
    }



}