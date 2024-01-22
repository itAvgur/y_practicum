package org.itavgur.sprint_6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_DTest extends Task_D {

    @Test
    public void test1() {

        Integer[] expected;
        Integer[] result;

        Integer[] brief = {4, 4};
        Integer[][] links = {{1, 2}, {2, 3}, {3, 4}, {1, 4}};
        expected = new Integer[]{3, 2, 4, 1};
        result = bfs(links, brief[0], 3);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {

        Integer[] expected;
        Integer[] result;

        Integer[] brief = {2, 1};
        Integer[][] links = {{2, 1}};
        expected = new Integer[]{1, 2};
        result = bfs(links, brief[0], 1);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFailed() {

        Integer[] expected;
        Integer[] result;

        Integer[] brief = {3, 2};
        Integer[][] links = {{3, 2}, {1, 3}};
        expected = new Integer[]{3, 1, 2};
        result = bfs(links, brief[0], 3);
        assertArrayEquals(expected, result);
    }

}