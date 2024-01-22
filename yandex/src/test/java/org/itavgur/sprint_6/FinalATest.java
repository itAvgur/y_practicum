package org.itavgur.sprint_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FinalATest extends FinalA {

    @Test
    public void test() {

        Integer[] input;
        String expected;
        String result;

        input = new Integer[]{4, 4, 1, 2, 5, 1, 3, 6, 2, 4, 8, 3, 4, 3};
        expected = "19";
        result = FinalA.process(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test2() {

        Integer[] input;
        String expected;
        String result;

        input = new Integer[]{3, 3, 1, 2, 1, 1, 2, 2, 2, 3, 1};
        expected = "3";
        result = FinalA.process(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test3() {

        Integer[] input;
        String expected;
        String result;

        input = new Integer[]{2, 0};
        expected = "Oops! I did it again";
        result = FinalA.process(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test4() {

        Integer[] input;
        String expected;
        String result;

        input = new Integer[]{5, 3, 1, 2, 10, 3, 4, 20, 4, 5, 30};
        expected = "Oops! I did it again";
        result = FinalA.process(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFailed1() {

        Integer[] input;
        String expected;
        String result;

        input = new Integer[]{1, 0};
        expected = "0";
        result = FinalA.process(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFailed2() {

        Integer[] input;
        String expected;
        String result;

        input = new Integer[]{
                10, 20,
                8, 7, 9,
                4, 10, 7,
                6, 6, 2,
                8, 10, 1,
                10, 6, 1,
                5, 7, 8,
                1, 9, 6,
                10, 3, 3,
                10, 5, 8,
                6, 6, 6,
                5, 7, 9,
                5, 2, 4,
                3, 1, 1,
                10, 7, 8,
                8, 4, 6,
                5, 5, 7,
                7, 8, 6,
                5, 10, 2,
                10, 1, 3,
                3, 5, 9};
        expected = "56";
        result = FinalA.process(input);
        Assertions.assertEquals(expected, result);
    }


}