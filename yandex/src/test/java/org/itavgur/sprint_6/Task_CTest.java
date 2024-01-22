package org.itavgur.sprint_6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_CTest {

    @Test
    public void test1() {

        Integer[] expected;
        Integer[] result;

        Integer[] brief = {4, 4};
        Integer[][] links = {{3, 2}, {4, 3}, {1, 4}, {1, 2}};
        expected = new Integer[]{3, 2, 1, 4};
        result = Task_C.dfs(links, brief[0], 3);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {

        Integer[] expected;
        Integer[] result;

        Integer[] brief = {2, 1};
        Integer[][] links = {{1, 2}};
        expected = new Integer[]{1, 2};
        result = Task_C.dfs(links, brief[0], 1);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFailed1() {

        Integer[] expected;
        Integer[] result;

        Integer[] brief = {3, 1};
        Integer[][] links = {{2, 3}};
        expected = new Integer[]{1};
        result = Task_C.dfs(links, brief[0], 1);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFailed2() {

        Integer[] expected;
        Integer[] result;

        Integer[] brief = {6, 7};
        Integer[][] links = {{3, 2}, {5, 4}, {3, 1}, {1, 4}, {1, 6}, {1, 2}, {1, 5}};
        expected = new Integer[]{1, 2, 3, 4, 5, 6};
        result = Task_C.dfs(links, brief[0], 1);
        assertArrayEquals(expected, result);
    }

}