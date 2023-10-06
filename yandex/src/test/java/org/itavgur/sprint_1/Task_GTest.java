package org.itavgur.sprint_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_GTest {

    @Test
    public void test() {
        String result;

        int input0 = 0;
        result = Task_G.process(input0);
        assertEquals("0", result);

        int input1 = 5;
        result = Task_G.process(input1);
        assertEquals("101", result);

        int input2 = 14;
        result = Task_G.process(input2);
        assertEquals("1110", result);

        int input3 = 546;
        result = Task_G.process(input3);
        assertEquals(Integer.toBinaryString(input3), result);

    }
}