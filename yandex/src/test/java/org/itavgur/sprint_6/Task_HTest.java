package org.itavgur.sprint_6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_HTest extends Task_H {

    @Test
    public void test1() {

        Integer[][] expected;
        Integer[][] result;

        Integer[] brief = {6, 8};
        Integer[][] links = {{2, 6}, {1, 6}, {3, 1}, {2, 5}, {4, 3}, {3, 2}, {1, 2}, {1, 4}};
        expected = new Integer[][]{{0, 11}, {1, 6}, {8, 9}, {7, 10}, {2, 3}, {4, 5}};
        result = Task_H.dfsClassified(links, brief);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {

        Integer[][] expected;
        Integer[][] result;

        Integer[] brief = {3, 2};
        Integer[][] links = {{1, 2}, {2, 3}};
        expected = new Integer[][]{{0, 5}, {1, 4}, {2, 3}};
        result = Task_H.dfsClassified(links, brief);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFailed() {

        Integer[][] expected;
        Integer[][] result;

        Integer[] brief = {1, 0};
        expected = new Integer[][]{{0, 1}};
        result = Task_H.dfsClassified(new Integer[0][2], brief);
        assertArrayEquals(expected, result);
    }

}