package org.itavgur.sprint_8;

import org.junit.jupiter.api.Test;

import static org.itavgur.sprint_8.Task_A.DELIMITER;
import static org.itavgur.sprint_8.Task_A.stringReverse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_ATest {

    @Test
    public void test1() {

        String expected;
        String result;

        String[] data = "one two three".split(DELIMITER);
        expected = "three two one";
        result = stringReverse(data);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {

        String expected;
        String result;

        String[] data = "hello".split(DELIMITER);
        expected = "hello";
        result = stringReverse(data);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {

        String expected;
        String result;

        String[] data = "may the force be with you".split(DELIMITER);
        expected = "you with be force the may";
        result = stringReverse(data);
        assertEquals(expected, result);
    }


}