package org.itavgur.sprint_7;

import org.junit.jupiter.api.Test;

import static org.itavgur.sprint_7.Task_K.horoscopes;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class Task_KTest {

    @Test
    public void test1() {

        Integer[][] expected;
        Integer[][] result;

        expected = new Integer[][]{{3}, {1, 3, 4}, {2, 5, 7}};
        Integer[] seq1 = new Integer[]{4, 9, 2, 4, 6};
        Integer[] seq2 = new Integer[]{9, 4, 0, 0, 2, 8, 4};
        result = horoscopes(5, seq1, 7, seq2);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {

        Integer[][] expected;
        Integer[][] result;

        expected = new Integer[][]{{0}};
        Integer[] seq1 = new Integer[]{1, 1, 1, 1};
        Integer[] seq2 = new Integer[]{2, 2};
        result = horoscopes(4, seq1, 2, seq2);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test3() {

        Integer[][] expected;
        Integer[][] result;

        expected = new Integer[][]{{3}, {3, 4, 8}, {3, 4, 5}};
        Integer[] seq1 = new Integer[]{1, 2, 1, 9, 1, 2, 1, 9};
        Integer[] seq2 = new Integer[]{9, 9, 1, 9, 9};
        result = horoscopes(8, seq1, 5, seq2);
        assertArrayEquals(expected, result);
    }


}