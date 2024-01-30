package org.itavgur.sprint_7;

import org.junit.jupiter.api.Test;

import static org.itavgur.sprint_7.Task_F.jumps;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_FTest {

    @Test
    public void test1() {

        int expected;
        int result;

        expected = 13;
        result = jumps(6, 3);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {

        int expected;
        int result;

        expected = 32;
        result = jumps(7, 7);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {

        int expected;
        int result;

        expected = 1;
        result = jumps(2, 2);
        assertEquals(expected, result);
    }

    @Test
    public void test4() {

        int expected;
        int result;

        expected = 535806680;
        result = jumps(62, 44);
        assertEquals(expected, result);
    }

    @Test
    public void test5() {

        int expected;
        int result;

        expected = 672105806;
        result = jumps(1000, 1000);
        assertEquals(expected, result);
    }

}