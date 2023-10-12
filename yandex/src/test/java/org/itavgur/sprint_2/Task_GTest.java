package org.itavgur.sprint_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_GTest {

    @Test
    public void test1() {
        String[] result;
        String[] input;
        String[] expected;

        input = new String[]{"pop", "pop", "push 4", "push -5", "push 7", "pop", "pop", "get_max", "pop", "get_max"};
        result = Task_G.process(10, input);
        expected = new String[]{"error", "error", "4", "None"};
        assertArrayEquals(expected, result);

    }

    @Test
    public void test2() {
        String[] result;
        String[] input;
        String[] expected;

        input = new String[]{"get_max", "push -6", "pop", "pop", "get_max", "push 2", "get_max", "pop", "push -2", "push -6"};
        result = Task_G.process(10, input);
        expected = new String[]{"None", "error", "None", "2"};
        assertArrayEquals(expected, result);

    }

}