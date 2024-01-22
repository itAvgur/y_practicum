package org.itavgur.sprint_6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_KTest extends Task_K {

    @Test
    public void test1() {
        Integer[][] expected;
        Integer[][] result;

        Integer[] data = {4, 4, 1, 2, 1, 2, 3, 3, 3, 4, 5, 1, 4, 2};
        expected = new Integer[][]{
                {0, 1, 4, 2},
                {1, 0, 3, 3},
                {4, 3, 0, 5},
                {2, 3, 5, 0}

        };
        result = sightseeing(data);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {
        Integer[][] expected;
        Integer[][] result;

        Integer[] data = {3, 2, 1, 2, 1, 1, 2, 2};
        expected = new Integer[][]{
                {0, 1, -1},
                {1, 0, -1},
                {-1, -1, 0}
        };
        result = sightseeing(data);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test3() {
        Integer[][] expected;
        Integer[][] result;

        Integer[] data = {2, 0};
        expected = new Integer[][]{
                {0, -1},
                {-1, 0}
        };
        result = sightseeing(data);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFailed() {
        Integer[][] expected;
        Integer[][] result;

        Integer[] data = {6, 8, 4, 1, 3, 2, 1, 9, 1, 3, 3, 6, 5, 3, 3, 6, 8, 2, 6, 10, 2, 3, 5, 5, 3, 3};
        expected = new Integer[][]{
                {0, 8, 3, 3, 6, 9},
                {8, 0, 5, 11, 8, 10},
                {3, 5, 0, 6, 3, 6},
                {3, 11, 6, 0, 9, 12},
                {6, 8, 3, 9, 0, 3},
                {9, 10, 6, 12, 3, 0}
        };
        result = sightseeing(data);
        assertArrayEquals(expected, result);
    }

}