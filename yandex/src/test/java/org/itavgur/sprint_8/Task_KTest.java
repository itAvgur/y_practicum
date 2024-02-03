package org.itavgur.sprint_8;

import org.junit.jupiter.api.Test;

import static org.itavgur.sprint_8.Task_K.compareTwoString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_KTest {

    @Test
    public void test1() {

        int expected;
        int result;


        String str1 = "gggggbbb";
        String str2 = "bbef";
        expected = -1;
        result = compareTwoString(str1, str2);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {

        int expected;
        int result;

        String str1 = "z";
        String str2 = "aaaaaaa";
        expected = 1;
        result = compareTwoString(str1, str2);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {

        int expected;
        int result;

        String str1 = "ccccz";
        String str2 = "aaaaaz";
        expected = 0;
        result = compareTwoString(str1, str2);
        assertEquals(expected, result);
    }

}