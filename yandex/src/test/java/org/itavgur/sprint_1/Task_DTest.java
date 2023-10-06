package org.itavgur.sprint_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_DTest {

    @Test
    public void test() {
        Integer result;

        Integer[] input3 = {-243, -178, -50, -35, 244, -246, -70, 156, -48, 186};
        result = Task_D.process(input3);
        assertEquals(3, result);

        Integer[] input1 = {-1, -10, -8, 0, 2, 0, 5};
        result = Task_D.process(input1);
        assertEquals(3, result);

        Integer[] input2 = {1, 2, 5, 4, 8};
        result = Task_D.process(input2);
        assertEquals(2, result);

    }
}