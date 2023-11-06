package org.itavgur.sprint_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_ATest {

    @Test
    public void test() {

        long expected;
        long result;
        String input;

        input = "a";
        result = Task_A.process(123, 100003, input);
        expected = 97;
        assertEquals(expected, result);

        input = "hash";
        result = Task_A.process(123, 100003, input);
        expected = 6080;
        assertEquals(expected, result);

        input = "HaSH";
        result = Task_A.process(123, 100003, input);
        expected = 56156;
        assertEquals(expected, result);


    }

}