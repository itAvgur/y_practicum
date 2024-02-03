package org.itavgur.sprint_8;

import org.junit.jupiter.api.Test;

import static org.itavgur.sprint_8.Task_B.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_BTest {

    @Test
    public void test1() {

        String expected;
        String result;

        String passportName = "abcdefg";
        String dbName = "abdefg";
        expected = OK_ANSWER;
        result = customsControl(passportName, dbName);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {

        String expected;
        String result;

        String passportName = "helo";
        String dbName = "hello";
        expected = OK_ANSWER;
        result = customsControl(passportName, dbName);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {

        String expected;
        String result;

        String passportName = "dog";
        String dbName = "fog";
        expected = OK_ANSWER;
        result = customsControl(passportName, dbName);
        assertEquals(expected, result);
    }

    @Test
    public void test4() {

        String expected;
        String result;

        String passportName = "mama";
        String dbName = "papa";
        expected = FAIL_ANSWER;
        result = customsControl(passportName, dbName);
        assertEquals(expected, result);
    }

    @Test
    public void testFailed() {

        String expected;
        String result;

        String passportName = "jvcppyxvhklpolbtxnulimmxhaeswvfknfjikekj";
        String dbName = "jvcppyxvhklqpolbtxnulimmxhaeswvfknfjikek";
        expected = FAIL_ANSWER;
        result = customsControl(passportName, dbName);
        assertEquals(expected, result);
    }

    @Test
    public void testFailed2() {

        String expected;
        String result;

        String passportName = "abcd2";
        String dbName = "ab1cd";
        expected = FAIL_ANSWER;
        result = customsControl(passportName, dbName);
        assertEquals(expected, result);
    }


}