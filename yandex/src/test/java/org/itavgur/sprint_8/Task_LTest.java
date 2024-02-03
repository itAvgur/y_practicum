package org.itavgur.sprint_8;

import org.junit.jupiter.api.Test;

import static org.itavgur.sprint_8.Task_L.prefixFunction;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_LTest {

    @Test
    public void test1() {

        Integer[] expected;
        Integer[] result;

        String str = "abracadabra";
        expected = new Integer[]{0, 0, 0, 1, 0, 1, 0, 1, 2, 3, 4};
        result = prefixFunction(str);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {

        Integer[] expected;
        Integer[] result;

        String str = "xxzzxxz";
        expected = new Integer[]{0, 1, 0, 0, 1, 2, 3};
        result = prefixFunction(str);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test3() {

        Integer[] expected;
        Integer[] result;

        String str = "aaaaa";
        expected = new Integer[]{0, 1, 2, 3, 4};
        result = prefixFunction(str);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test() {

        Integer[] expected;
        Integer[] result;

        String str = "abacaba";
        expected = new Integer[]{0, 0, 1, 0, 1, 2, 3};
        result = prefixFunction(str);
        assertArrayEquals(expected, result);
    }

}