package org.itavgur.sprint_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_KTest {

    @Test
    public void test() {
        Integer[] result;
        Integer[] expected;
        Integer[] input;

        expected = new Integer[]{1, 6, 9, 6, 6};
        input = new Integer[]{9, 5, 1, 8};
        result = Task_K.process(input, 7448);
        assertArrayEquals(expected, result);

        expected = new Integer[]{1, 1, 2};
        input = new Integer[]{9, 5};
        result = Task_K.process(input, 17);
        assertArrayEquals(expected, result);

        expected = new Integer[]{1, 2, 3, 4};
        input = new Integer[]{1, 2, 0, 0};
        result = Task_K.process(input, 34);
        assertArrayEquals(expected, result);

    }

}