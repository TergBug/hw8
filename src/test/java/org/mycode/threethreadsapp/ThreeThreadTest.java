package org.mycode.threethreadsapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeThreadTest {
    private ThreeThread testedThreeThread = new ThreeThread();
    private int[] testedOrderMas1 = new int[]{1, 2, 3};
    private int[] testedOrderMas2 = new int[]{2, 3, 1};
    private int[] wrongOrderMas = new int[]{2, 4, 1};
    private String expectedStr = "firstsecondthird";
    @Test
    public void shouldPrintCorrectStr(){
        assertEquals(expectedStr, testedThreeThread.runUpThreeThreads(testedOrderMas1));
        assertEquals(expectedStr, testedThreeThread.runUpThreeThreads(testedOrderMas2));
    }
    @Test
    public void shouldReturnNullInExceptionCases(){
        assertNull(testedThreeThread.runUpThreeThreads(null));
        assertNull(testedThreeThread.runUpThreeThreads(new int[2]));
        assertNull(testedThreeThread.runUpThreeThreads(new int[4]));
        assertNull(testedThreeThread.runUpThreeThreads(wrongOrderMas));
    }
}