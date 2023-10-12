package org.itavgur.sprint_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_JTest {

    @Test
    public void test1() {
        String[] result;
        String[] input;
        String[] expected;

        input = new String[]{"put -34", "put -23", "get", "size", "get", "size", "get", "get", "put 80", "size"};
        expected = new String[]{"-34", "1", "-23", "0", "error", "error", "1"};
        result = Task_J.process(10, input);
        assertArrayEquals(expected, result);

        input = new String[]{"put -66", "put 98", "size", "size", "get", "get"};
        expected = new String[]{"2", "2", "-66", "98"};
        result = Task_J.process(10, input);
        assertArrayEquals(expected, result);

        input = new String[]{"get", "size", "put 74", "get", "size", "put 90", "size", "size", "size"};
        expected = new String[]{"error", "0", "74", "0", "1", "1", "1"};
        result = Task_J.process(10, input);
        assertArrayEquals(expected, result);

    }

}