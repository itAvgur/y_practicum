package org.itavgur.sprint_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Task_PTest {

    @Test
    @Disabled
    public void test() {

        Integer result;
        Integer[] input;
        Integer expected;

        input = new Integer[]{0, 1, 3, 2};
        result = Task_P.process(4, input);
        expected = 3;
        Assertions.assertEquals(expected, result);

        input = new Integer[]{3, 6, 7, 4, 1, 5, 0, 2};
        result = Task_P.process(8, input);
        expected = 1;
        Assertions.assertEquals(expected, result);

        input = new Integer[]{1, 0, 2, 3, 4};
        result = Task_P.process(5, input);
        expected = 4;
        Assertions.assertEquals(expected, result);
    }
}