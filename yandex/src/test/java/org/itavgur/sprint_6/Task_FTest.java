package org.itavgur.sprint_6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_FTest extends Task_F {

    @Test
    public void test1() {
        Integer expected;
        Integer result;

        Integer[] data = {5, 5, 2, 4, 3, 5, 2, 1, 2, 3, 4, 5, 1, 5};
        expected = 3;
        result = distanceBetweenNodes(data);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {
        Integer expected;
        Integer result;

        Integer[] data = {4, 3, 2, 3, 4, 3, 2, 4, 1, 3};
        expected = -1;
        result = distanceBetweenNodes(data);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {
        Integer expected;
        Integer result;

        Integer[] data = {2, 1, 2, 1, 1, 1};
        expected = 0;
        result = distanceBetweenNodes(data);
        assertEquals(expected, result);
    }

}