package org.itavgur.sprint_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_HTest {

    @Test
    public void test() {

        String expected;
        String result;

        result = Task_H.process("mxyskaoghi", "qodfrgmslc");
        expected = "YES";
        assertEquals(expected, result);

        result = Task_H.process("agg", "xdd");
        expected = "YES";
        assertEquals(expected, result);

        result = Task_H.process("agg", "xda");
        expected = "NO";
        assertEquals(expected, result);

    }

    @Test
    public void testFailed() {

        String expected;
        String result;

        result = Task_H.process("abacaba", "abacabac");
        expected = "NO";
        assertEquals(expected, result);

        result = Task_H.process("aba", "xxx");
        expected = "NO";
        assertEquals(expected, result);

    }

}