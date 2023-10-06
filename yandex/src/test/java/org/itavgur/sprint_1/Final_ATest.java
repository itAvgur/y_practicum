package org.itavgur.sprint_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Final_ATest {

    @Test
    public void test() {
        Integer[] result;
        Integer[] input;
        Integer[] expected;

        expected = new Integer[]{0, 1, 2, 1, 0};
        input = new Integer[]{0, 1, 4, 9, 0};
        result = Final_A.process(5, input);
        assertArrayEquals(expected, result);

        expected = new Integer[]{0, 1, 2, 3, 4, 5};
        input = new Integer[]{0, 7, 9, 4, 8, 20};
        result = Final_A.process(6, input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testBad() {
        Integer[] result;
        Integer[] input;
        Integer[] expected;

        expected = new Integer[]{1, 0, 1, 1, 0, 1, 1, 0, 1};
        input = new Integer[]{98, 0, 10, 77, 0, 59, 28, 0, 94};
        result = Final_A.process(5, input);
        assertArrayEquals(expected, result);

    }
}