package org.itavgur.sprint_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_JTest {

    @Test
    public void test() {

        Integer[][] result;
        Integer[] input;
        Integer[][] expected;

        input = new Integer[]{-5, 14, -4, 3, 0, -2, -1, 6};
        result = Task_J.process(input);
        expected = new Integer[][]{
                {-5, -4, 3, 0, -2, -1, 6, 14},
                {-5, -4, 0, -2, -1, 3, 6, 14},
                {-5, -4, -2, -1, 0, 3, 6, 14}};
        assertArrayEquals(expected, result);

        input = new Integer[]{1, 1, 1, 1};
        result = Task_J.process(input);
        expected = new Integer[][]{
                {1, 1, 1, 1}};
        assertArrayEquals(expected, result);

        input = new Integer[]{4, 5};
        result = Task_J.process(input);
        expected = new Integer[][]{
                {4, 5}};
        assertArrayEquals(expected, result);

        input = new Integer[]{4, 3, 9, 2, 1};
        result = Task_J.process(input);
        expected = new Integer[][]{
                {3, 4, 2, 1, 9},
                {3, 2, 1, 4, 9},
                {2, 1, 3, 4, 9},
                {1, 2, 3, 4, 9}};
        assertArrayEquals(expected, result);

        input = new Integer[]{4, 3, 9, 2, 1};
        result = Task_J.process(input);
        expected = new Integer[][]{
                {3, 4, 2, 1, 9},
                {3, 2, 1, 4, 9},
                {2, 1, 3, 4, 9},
                {1, 2, 3, 4, 9}};
        assertArrayEquals(expected, result);
    }
}