package org.itavgur.sprint_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task_NTest {

    @Test
    public void test() {

        Integer[][] result;
        Integer[][] input;
        Integer[][] expected;

        input = new Integer[][]{{7, 8}, {7, 8}, {2, 3}, {6, 10}};
        result = Task_N.process(4, input);
        expected = new Integer[][]{{2, 3}, {6, 10}};
        Assertions.assertArrayEquals(expected, result);

        input = new Integer[][]{
                {0, 20},
                {30, 50},
                {10, 40}};
        result = Task_N.process(3, input);
        expected = new Integer[][]{{0, 50}};
        Assertions.assertArrayEquals(expected, result);


        input = new Integer[][]{
                {4, 13},
                {42, 71},
                {6, 43},
                {42, 89},
                {0, 55}};
        result = Task_N.process(9, input);
        expected = new Integer[][]{{0, 89}};
        Assertions.assertArrayEquals(expected, result);

        input = new Integer[][]{{1, 2}, {5, 6}, {1, 6}};
        result = Task_N.process(3, input);
        expected = new Integer[][]{{1, 6}};
        Assertions.assertArrayEquals(expected, result);

        input = new Integer[][]{{1, 3}, {3, 5}, {4, 6}, {5, 6}, {2, 4}, {7, 10}};
        result = Task_N.process(6, input);
        expected = new Integer[][]{{1, 6}, {7, 10}};
        Assertions.assertArrayEquals(expected, result);

        input = new Integer[][]{{2, 3}, {5, 6}, {3, 4}, {3, 4}};
        result = Task_N.process(4, input);
        expected = new Integer[][]{{2, 4}, {5, 6}};
        Assertions.assertArrayEquals(expected, result);

    }
}