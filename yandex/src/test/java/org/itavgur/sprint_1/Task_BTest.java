package org.itavgur.sprint_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_BTest {

    @Test
    public void test() {
        String result;

        Integer[] input4 = {21, 19, -25};
        result = Task_B.process(input4);
        assertEquals("WIN", result);

        Integer[] input1 = {1, 2, -3};
        result = Task_B.process(input1);
        assertEquals("FAIL", result);

        Integer[] input2 = {7, 11, 7};
        result = Task_B.process(input2);
        assertEquals("WIN", result);

        Integer[] input3 = {6, -2, 0};
        result = Task_B.process(input3);
        assertEquals("WIN", result);

    }

}