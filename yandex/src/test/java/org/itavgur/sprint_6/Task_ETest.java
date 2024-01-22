package org.itavgur.sprint_6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_ETest extends Task_E {

    @Test
    public void test1() {

        Integer[][] expected;
        Integer[][] result;

        Integer[] brief = {6, 3};
        Integer[][] links = {{1, 2}, {6, 5}, {2, 3}};
        expected = new Integer[][]{
                new Integer[]{3},
                new Integer[]{1, 2, 3},
                new Integer[]{4},
                new Integer[]{5, 6}
        };
        result = process(links, brief);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {

        Integer[][] expected;
        Integer[][] result;

        Integer[] brief = {2, 0};
        Integer[][] links = new Integer[0][0];
        expected = new Integer[][]{
                new Integer[]{2},
                new Integer[]{1},
                new Integer[]{2}
        };
        result = process(links, brief);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test3() {

        Integer[][] expected;
        Integer[][] result;

        Integer[] brief = {4, 3};
        Integer[][] links = {{2, 3}, {2, 1}, {4, 3}};
        expected = new Integer[][]{
                new Integer[]{1},
                new Integer[]{1, 2, 3, 4}
        };
        result = process(links, brief);
        assertArrayEquals(expected, result);
    }


//    @Test
//    public void testOrder() {
//
//        Integer[][] expected;
//        Integer[][] result;
//
//        Integer[] brief = {10, 3};
//        Integer[][] links = {{1, 6}, {2, 5}, {4, 3}};
//        expected = new Integer[][]{
//                new Integer[]{3},
//                new Integer[]{1, 2, 10},
//                new Integer[]{3, 5},
//                new Integer[]{3, 4}
//        };
//        result = process(links, brief);
//        assertArrayEquals(expected, result);
//    }
}