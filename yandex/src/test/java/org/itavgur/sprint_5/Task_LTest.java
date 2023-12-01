package org.itavgur.sprint_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task_LTest extends Task_L {

    @Test
    public void test() {

        int[] sample = {-1, 12, 1, 8, 3, 4, 7};
        Assertions.assertEquals(5, siftDown(sample, 2));
    }

    @Test
    public void test1() {

        int[] sample = {-1, 12, 1, 8, 3};
        Assertions.assertEquals(4, siftDown(sample, 2));
    }

    @Test
    public void test2() {

        int[] sample = {-1, 50, 80, 40, 30, 35, 33, 38, 20, 25};
        Assertions.assertEquals(2, siftDown(sample, 1));
    }

    @Test
    public void test3() {

        int[] sample = {-1, 50, 41, 40, 30, 35, 33, 38, 20, 25};
        Assertions.assertEquals(1, siftDown(sample, 1));
    }

    @Test
    public void test4() {

        int[] sample = {-1, 50, 5, 40, 35, 30, 33, 38, 20, 25};
        Assertions.assertEquals(9, siftDown(sample, 2));
    }

    @Test
    public void test5() {

        int[] sample = {-1, 50, 5, 40, 35, 30, 33, 38, 25, 20};
        Assertions.assertEquals(8, siftDown(sample, 2));
    }

    @Test
    public void test6() {

        int[] sample = {-1, 50, 5, 40, 35, 30, 33, 38, 1, 4};
        Assertions.assertEquals(4, siftDown(sample, 2));
    }

    @Test
    public void test7() {

        int[] sample = {-1, 3, 41, 42, 35, 30, 33, 38, 1, 4};
        Assertions.assertEquals(7, siftDown(sample, 1));
    }

    @Test
    public void test9() {

        int[] sample = {-1, 39, 41, 42, 35, 30, 33, 38, 1, 4};
        Assertions.assertEquals(3, siftDown(sample, 1));
    }

}