package org.itavgur.sprint_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_ATest {

    @Test
    public void test() {

        String[] expected;
        String[] result;

        result = Task_A.process(2);
        expected = new String[]{"(())", "()()"};
        assertArrayEquals(expected, result);

        result = Task_A.process(3);
        expected = new String[]{"((()))", "(()())", "(())()", "()(())", "()()()"};
        assertArrayEquals(expected, result);

    }

}