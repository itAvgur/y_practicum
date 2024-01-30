package org.itavgur.sprint_7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinalATest extends FinalA {

    @Test
    public void test1() {

        int expected;
        int result;

        String str1 = "abacaba";
        String str2 = "abaabc";
        expected = 2;
        result = FinalA.process(str1, str2);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {

        int expected;
        int result;

        String str1 = "innokentiy";
        String str2 = "innnokkentia";
        expected = 3;
        result = FinalA.process(str1, str2);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {

        int expected;
        int result;

        String str1 = "r";
        String str2 = "x";
        expected = 1;
        result = FinalA.process(str1, str2);
        assertEquals(expected, result);
    }

    @Test
    public void testFailed() {

        int expected;
        int result;

        String str1 = "dxqrpmratn";
        String str2 = "jdpmykgmaitn";
        expected = 8;
        result = FinalA.process(str1, str2);
        assertEquals(expected, result);
    }

}