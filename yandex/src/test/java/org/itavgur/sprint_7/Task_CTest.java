package org.itavgur.sprint_7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.itavgur.sprint_7.Task_C.gold;

class Task_CTest {

    @Test
    public void test1() {

        long expected;
        long result;

        int capacity = 10;
        int goldTotal = 3;
        Integer[][] gold = {{8, 1}, {2, 10}, {4, 5}};
        expected = 36;
        result = gold(capacity, goldTotal, gold);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test2() {

        long expected;
        long result;

        int capacity = 10000;
        int goldTotal = 1;
        Integer[][] gold = {{4, 20}};
        expected = 80;
        result = gold(capacity, goldTotal, gold);
        Assertions.assertEquals(expected, result);
    }

}