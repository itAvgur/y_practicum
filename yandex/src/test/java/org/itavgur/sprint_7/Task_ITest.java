package org.itavgur.sprint_7;

import org.junit.jupiter.api.Test;

import static org.itavgur.sprint_7.Task_I.maxFlowersPath;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_ITest {

    @Test
    public void test1() {

        String[] expected;
        String[] result;

        expected = new String[]{"3", "URR"};
        String[] field = new String[]{"101", "110"};
        result = maxFlowersPath(2, 3, field);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {

        String[] expected;
        String[] result;

        expected = new String[]{"2", "UURR"};
        String[] field = new String[]{"100", "110", "001"};
        result = maxFlowersPath(3, 3, field);
        assertArrayEquals(expected, result);
    }

}