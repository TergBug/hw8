package org.mycode.fizzbuzzapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzWithThreadsTest {
    private FizzBuzzWithThreads testedFizzBuzz = new FizzBuzzWithThreads();
    private int maxNumber = 15;
    private String expectedStr = "1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz";
    @Test
    public void shouldPrintCorrectStr(){
        assertEquals(expectedStr, testedFizzBuzz.runUpFizzBuzzThreads(maxNumber));
    }
    @Test
    public void shouldReturnNullInExceptionCases(){
        assertNull(testedFizzBuzz.runUpFizzBuzzThreads(0));
    }
}