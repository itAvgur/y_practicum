package org.itavgur.sprint_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_FTest {

    @Test
    public void test1() {
        String[] result;
        String[] input;
        String[] expected;

        input = new String[]{"get_max", "pop", "pop", "pop", "push 10", "get_max", "push -9"};
        result = Task_F.process(9, input);
        expected = new String[]{"None", "error", "error", "error", "10"};
        assertArrayEquals(expected, result);

    }

    @Test
    public void test2() {
        String[] result;
        String[] input;
        String[] expected;

        input = new String[]{"get_max", "push 7", "pop", "push -2", "push -1", "pop", "get_max", "get_max"};
        result = Task_F.process(9, input);
        expected = new String[]{"None", "-2", "-2"};
        assertArrayEquals(expected, result);

    }
}