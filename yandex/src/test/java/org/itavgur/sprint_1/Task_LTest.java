package org.itavgur.sprint_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_LTest {

    @Test
    public void test() {
        String result;
        String[] input;

        input = new String[]{"abcd", "abcde"};
        result = Task_L.process(input);
        assertEquals("e", result);

        input = new String[]{"go", "ogg"};
        result = Task_L.process(input);
        assertEquals("g", result);

        input = new String[]{"xtkpx", "xkctpx"};
        result = Task_L.process(input);
        assertEquals("c", result);

    }

}