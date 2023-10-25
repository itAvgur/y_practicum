package org.itavgur.sprint_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task_ITest {

    @Test
    public void test() {

        Integer[] result;
        Integer[] input;
        Integer[] expected;

        input = new Integer[]{1, 2, 3, 1, 2, 3, 4};
        result = Task_I.process(7, input, 3);
        expected = new Integer[]{1, 2, 3};
        Assertions.assertArrayEquals(expected, result);

        input = new Integer[]{1, 1, 1, 2, 2, 3};
        result = Task_I.process(6, input, 1);
        expected = new Integer[]{1};
        Assertions.assertArrayEquals(expected, result);

    }

    @Test
    public void testFailed() {

        Integer[] result;
        Integer[] input;
        Integer[] expected;

        input = new Integer[]{1, 1, 1, 2, 2, 3, 7, 5, 5};
        result = Task_I.process(9, input, 3);
        expected = new Integer[]{1, 2, 5};
        Assertions.assertArrayEquals(expected, result);

    }

}