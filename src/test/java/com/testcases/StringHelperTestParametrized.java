package com.testcases;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StringHelperTestParametrized {
//her Parametrized classında yalnızca bir tane test bulnuur çünkü 1 tane constructor var

    StringHelper stringHelper = new StringHelper();

    //parameters
    private String input;
    private String expectedOutput;

    public StringHelperTestParametrized(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters //thank to this annotation, it will directly map the return value to the parameters defined above(input,expectedOutput)
    public static Collection<String[]> testConditions(){
        String expectedOutputs[][] = {{"AD","CD"},{"AACD","CD"}};

        return Arrays.asList(expectedOutputs);

    }


    //all unit tests should be public and void, otherwise it wont work
    @Test
    public void testTruncateAInFirst2Positions(){

        assertEquals(expectedOutput, stringHelper.truncateAInFirst2Positions(input));

    }




}