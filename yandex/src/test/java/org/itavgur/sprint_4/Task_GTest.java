package org.itavgur.sprint_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_GTest {

    @Test
    public void test() {

        Integer expected;
        Integer result;
        Integer[] input;

        input = new Integer[]{0, 0, 1, 0, 0, 0, 1, 0, 0, 1};
        result = Task_G.process(10, input);
        expected = 4;
        assertEquals(expected, result);

        input = new Integer[]{0, 1, 1, 0};
        result = Task_G.process(4, input);
        expected = 4;
        assertEquals(expected, result);

        input = new Integer[]{0, 1, 0};
        result = Task_G.process(3, input);
        expected = 2;
        assertEquals(expected, result);

    }

    @Test
    public void testFailed() {

        Integer expected;
        Integer result;
        Integer[] input;

        input = new Integer[]{0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1};
        result = Task_G.process(16, input);
        expected = 14;
        assertEquals(expected, result);


    }

    @Test
    public void testFailedLong() {

        Integer expected;
        Integer result;
        Integer[] input;


        input = new Integer[]{1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1};
        result = Task_G.process(85, input);
        expected = 30;
        assertEquals(expected, result);


        input = new Integer[]{1, 1, 1, 1, 1, 1};
        result = Task_G.process(6, input);
        expected = 0;
        assertEquals(expected, result);


    }

}