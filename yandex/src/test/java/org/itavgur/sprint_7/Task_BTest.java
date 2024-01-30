package org.itavgur.sprint_7;

import org.junit.jupiter.api.Test;

import static org.itavgur.sprint_7.Task_B.schedule;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_BTest {

    @Test
    public void test1() {

        String[][] expected;
        String[][] result;

        int size = 5;
        String[][] events = {{"9", "10"}, {"9.3", "10.3"}, {"10", "11"}, {"10.3", "11.3"}, {"11", "12"}};
        expected = new String[][]{{"3"}, {"9", "10"}, {"10", "11"}, {"11", "12"}};
        result = schedule(size, events);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {

        String[][] expected;
        String[][] result;

        int size = 3;
        String[][] events = {{"9", "10"}, {"11", "12.25"}, {"12.15", "13.3"}};
        expected = new String[][]{{"2"}, {"9", "10"}, {"11", "12.25"}};
        result = schedule(size, events);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test3() {

        String[][] expected;
        String[][] result;

        int size = 7;
        String[][] events = {{"19", "19"}, {"7", "14"}, {"12", "14"}, {"8", "22"}, {"22", "23"}, {"5", "21"}, {"9", "23"}};
        expected = new String[][]{{"3"}, {"7", "14"}, {"19", "19"}, {"22", "23"}};
        result = schedule(size, events);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFailed() {

        String[][] expected;
        String[][] result;

        int size = 8;
        String[][] events = {{"9", "10"}, {"12", "13"}, {"11", "13"}, {"13", "13"},
                {"18", "19"}, {"19", "20"}, {"20", "20"}, {"20", "21"}};
        expected = new String[][]{{"7"}, {"9", "10"}, {"11", "13"}, {"13", "13"},
                {"18", "19"}, {"19", "20"}, {"20", "20"}, {"20", "21"}};
        result = schedule(size, events);
        assertArrayEquals(expected, result);
    }

}