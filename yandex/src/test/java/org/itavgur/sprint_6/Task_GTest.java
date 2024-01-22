package org.itavgur.sprint_6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_GTest extends Task_G {

    @Test
    public void test1() {
        Integer expected;
        Integer result;

        Integer[] brief = {5, 4};
        Integer[][] links = {{2, 1}, {4, 5}, {4, 3}, {3, 2}};
        expected = 3;
        result = maxDistance(links, brief[0], 2);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {
        Integer expected;
        Integer result;

        Integer[] brief = {3, 3};
        Integer[][] links = {{3, 1}, {1, 2}, {2, 3}};
        expected = 1;
        result = maxDistance(links, brief[0], 1);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {
        Integer expected;
        Integer result;

        Integer[] brief = {6, 8};
        Integer[][] links = {{6, 1}, {1, 3}, {5, 1}, {3, 5}, {3, 4}, {6, 5}, {5, 2}, {6, 2}};
        expected = 3;
        result = maxDistance(links, brief[0], 4);
        assertEquals(expected, result);
    }


}