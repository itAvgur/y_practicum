package org.itavgur.sprint_7;

import org.junit.jupiter.api.Test;

import static org.itavgur.sprint_7.Task_H.maxFlowersSearch;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_HTest {

    @Test
    public void test1() {

        int expected;
        int result;

        expected = 3;
        String[] field = new String[]{"101", "110"};
        result = maxFlowersSearch(2, 3, field);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {

        int expected;
        int result;

        expected = 2;
        String[] field = new String[]{"100", "110", "001"};
        result = maxFlowersSearch(3, 3, field);
        assertEquals(expected, result);
    }
}