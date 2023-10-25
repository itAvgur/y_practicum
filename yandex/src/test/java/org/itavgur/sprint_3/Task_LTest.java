package org.itavgur.sprint_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_LTest {

    @Test
    public void test() {

        Integer[] result;
        Integer[] input;
        Integer[] expected;

        input = new Integer[]{1, 2, 4, 4, 6, 8};
        result = Task_L.process(input, 3);
        expected = new Integer[]{3, 5};
        assertArrayEquals(expected, result);

        input = new Integer[]{1, 2, 4, 4, 4, 4};
        result = Task_L.process(input, 3);
        expected = new Integer[]{3, -1};
        assertArrayEquals(expected, result);

        input = new Integer[]{1, 2, 4, 4, 4, 4};
        result = Task_L.process(input, 10);
        expected = new Integer[]{-1, -1};
        assertArrayEquals(expected, result);
    }
}