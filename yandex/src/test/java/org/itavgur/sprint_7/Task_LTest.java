package org.itavgur.sprint_7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.itavgur.sprint_7.Task_L.leprechaunGold;


class Task_LTest {

    @Test
    public void test1() {

        int expected;
        int result;

        expected = 15;
        Integer[] gold = new Integer[]{3, 8, 1, 2, 5};
        result = leprechaunGold(5, 15, gold);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test2() {

        int expected;
        int result;

        expected = 18;
        Integer[] gold = new Integer[]{10, 10, 7, 7, 4};
        result = leprechaunGold(5, 19, gold);
        Assertions.assertEquals(expected, result);
    }


}