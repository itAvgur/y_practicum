package org.itavgur.sprint_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_HTest {

    @Test
    public void test() {
        String result;

        String[] input3 = {"11", "11"};
        result = Task_H.process(input3[0], input3[1]);
        assertEquals("110", result);

        String[] input4 = {"11001", "10111100"};
        result = Task_H.process(input4[0], input4[1]);
        assertEquals("11010101", result);

        String[] input1 = {"1010", "1011"};
        result = Task_H.process(input1[0], input1[1]);
        assertEquals("10101", result);

        String[] input2 = {"1", "1"};
        result = Task_H.process(input2[0], input2[1]);
        assertEquals("10", result);

    }

}