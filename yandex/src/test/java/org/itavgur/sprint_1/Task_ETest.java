package org.itavgur.sprint_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_ETest {

    @Test
    public void test() {
        String result;

        String[] input1 = "i love segment tree".trim().split(" ");
        result = Task_E.process(input1, 19);
        assertEquals("segment", result);


        String[] input2 = "frog jumps from river".trim().split(" ");
        result = Task_E.process(input2, 21);
        assertEquals("jumps", result);

    }
}