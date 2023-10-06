package org.itavgur.sprint_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_JTest {

    @Test
    public void test() {
        Integer[] result;
        Integer[] expected;

        expected = new Integer[]{491, 2153};
        result = Task_J.process(1057123);
        assertArrayEquals(expected, result);

        expected = new Integer[]{2, 2, 2};
        result = Task_J.process(8);
        assertArrayEquals(expected, result);

        expected = new Integer[]{13};
        result = Task_J.process(13);
        assertArrayEquals(expected, result);

        expected = new Integer[]{2, 2, 5, 5};
        result = Task_J.process(100);
        assertArrayEquals(expected, result);

    }

    @Test
    public void longTest() {
        Integer[] result;
        Integer[] expected;

        expected = new Integer[]{7, 4951, 23143};
        result = Task_J.process(802066951);
        assertArrayEquals(expected, result);

        expected = new Integer[]{13, 70578583};
        result = Task_J.process(917521579);
        assertArrayEquals(expected, result);

    }
}