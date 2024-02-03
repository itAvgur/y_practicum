package org.itavgur.sprint_8;

import org.junit.jupiter.api.Test;

import static org.itavgur.sprint_8.Task_G.findSequence;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_GTest {

    @Test
    public void test1() {

        Integer[] expected;
        Integer[] result;

        Integer[] data = {3, 9, 1, 2, 5, 10, 9, 1, 7};
        Integer[] template = {4, 10};
        expected = new Integer[]{1, 8};
        result = findSequence(9, data, 3, template);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {

        Integer[] expected;
        Integer[] result;

        Integer[] data = {1, 2, 3, 4, 5};
        Integer[] template = {10, 11, 12};
        expected = new Integer[]{1, 2, 3};
        result = findSequence(5, data, 3, template);
        assertArrayEquals(expected, result);
    }


}