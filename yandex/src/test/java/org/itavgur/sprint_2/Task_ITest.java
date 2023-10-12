package org.itavgur.sprint_2;

import org.junit.jupiter.api.Test;

import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_ITest {

    @Test
    public void test1() {
        String[] result;
        String[] input;
        String[] expected;

        input = new String[]{"push -5", "peek", "pop", "peek", "size"};
        result = Task_I.process(5, 2, input);
        expected = new String[]{"-5", "-5", "None", "0"};
        assertArrayEquals(expected, result);

        input = new String[]{"peek", "push 5", "push 2", "peek", "size", "size", "push 1", "size"};
        result = Task_I.process(8, 2, input);
        expected = new String[]{"None", "5", "2", "2", "error", "2"};
        assertArrayEquals(expected, result);

        input = new String[]{"push 1", "size", "push 3", "size", "push 1", "pop", "push 1", "pop", "push 3", "push 3"};
        result = Task_I.process(10, 1, input);
        expected = new String[]{"1", "error", "1", "error", "1", "1", "error"};
        assertArrayEquals(expected, result);

    }

    @Test
    public void testPrint() {

        String[] array= new String[]{"1", "error", "1", "error", "1", "1", "error"};
        PrintWriter output = new PrintWriter(System.out);
        for (String string : array) {
            output.println(string);
        }

        output.flush();
        output.close();
    }

}