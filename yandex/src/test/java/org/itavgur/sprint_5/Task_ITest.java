package org.itavgur.sprint_5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_ITest extends Task_I {

    @Test
    public void test() {

        Integer expected;
        Integer result;

        result = Task_I.process(4);
        expected = 14;
        assertEquals(expected, result);

        result = Task_I.process(5);
        expected = 42;
        assertEquals(expected, result);

        result = Task_I.process(7);
        expected = 429;
        assertEquals(expected, result);

        result = Task_I.process(6);
        expected = 132;
        assertEquals(expected, result);

        result = Task_I.process(7);
        expected = 429;
        assertEquals(expected, result);
    }

}