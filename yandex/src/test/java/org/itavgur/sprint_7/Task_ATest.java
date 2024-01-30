package org.itavgur.sprint_7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_ATest {

    @Test
    public void test1() {

        int expected;
        int result;

        int size = 6;
        Integer[] prices = {7, 1, 5, 3, 6, 4};
        expected = 7;
        result = Task_A.process(size, prices);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {

        int expected;
        int result;

        int size = 4;
        Integer[] prices = {1, 2, 3, 4, 5};
        expected = 4;
        result = Task_A.process(size, prices);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {

        int expected;
        int result;

        int size = 6;
        Integer[] prices = {1, 12, 12, 16, 1, 8};
        expected = 22;
        result = Task_A.process(size, prices);
        assertEquals(expected, result);
    }

    @Test
    public void test4() {

        int expected;
        int result;

        int size = 6;
        Integer[] prices = {0, 3, 3, 0, 5, 5};
        expected = 8;
        result = Task_A.process(size, prices);
        assertEquals(expected, result);
    }

}