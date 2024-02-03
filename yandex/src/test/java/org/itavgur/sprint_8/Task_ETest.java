package org.itavgur.sprint_8;

import org.junit.jupiter.api.Test;

import static org.itavgur.sprint_8.Task_E.insertString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_ETest {

    @Test
    public void test1() {

        String expected;
        String result;

        String original = "abacaba";
        int newStringsNumber = 3;
        Task_E.NewString[] newStrings = new Task_E.NewString[]{
                new Task_E.NewString("queue", 2),
                new Task_E.NewString("deque", 0),
                new Task_E.NewString("stack", 7)
        };
        expected = "dequeabqueueacabastack";
        result = insertString(original, newStringsNumber, newStrings);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {

        String expected;
        String result;

        String original = "kukareku";
        int newStringsNumber = 2;
        Task_E.NewString[] newStrings = new Task_E.NewString[]{
                new Task_E.NewString("p", 1),
                new Task_E.NewString("q", 2)
        };
        expected = "kpuqkareku";
        result = insertString(original, newStringsNumber, newStrings);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {

        String expected;
        String result;

        String original = "abcdef";
        int newStringsNumber = 2;
        Task_E.NewString[] newStrings = new Task_E.NewString[]{
                new Task_E.NewString("xx", 2),
                new Task_E.NewString("yy", 4)
        };
        expected = "abxxcdyyef";
        result = insertString(original, newStringsNumber, newStrings);
        assertEquals(expected, result);
    }

}