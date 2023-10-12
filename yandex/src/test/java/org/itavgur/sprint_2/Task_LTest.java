package org.itavgur.sprint_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_LTest {

    @Test
    public void test() {

        Integer[] input;

        input = new Integer[]{3, 1};
        assertEquals(3, Task_L.process(input));

        input = new Integer[]{10, 1};
        assertEquals(9, Task_L.process(input));
    }

}