package com.testcases;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


public class ArrayCompareTest {



    @Test
    public void testArraySort_RandomArray(){

        int[] numbers = {12,2,53,4};
        int[] expected = {2,4,12,53};

        Arrays.sort(numbers); //inplace sort yapar.Return olarak bir array vermez direkt numberı kendi içinde sortlar

        assertArrayEquals(expected,numbers);
        //Normal assertEqual metodu arrayleri karşılaştırırken aynı da olsa referansları farklı old. için farklı görür.Have same values but they are different objects

    }

    @Test(expected = NullPointerException.class) //null pointer bekliyoruz demek
    public void testArraySort_NullArray(){

        int[] numbers = null;
        Arrays.sort(numbers); //inplace sort yapar.Return olarak bir array vermez direkt numberı kendi içinde sortlar

    }


    //performance test
    @Test(timeout = 1000) //it should be executed in 1000ms
    public void testSort_Performance(){
        int[] array = {12,23,4};
        for(int i=1; i<=1000000;i++){
            array[0] =i;
            Arrays.sort(array);
        }

    }

}
