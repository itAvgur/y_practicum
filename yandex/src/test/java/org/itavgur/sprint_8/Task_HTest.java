package org.itavgur.sprint_8;

import org.junit.jupiter.api.Test;

import static org.itavgur.sprint_8.Task_H.cutPastString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_HTest {

    @Test
    public void test1() {

        String expected;
        String result;

        String original = "pingpong";
        String cut = "ng";
        String paste = "mpi";
        expected = "pimpipompi";
        result = cutPastString(original, cut, paste);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {

        String expected;
        String result;

        String original = "aaa";
        String cut = "a";
        String paste = "ab";
        expected = "ababab";
        result = cutPastString(original, cut, paste);
        assertEquals(expected, result);
    }


}