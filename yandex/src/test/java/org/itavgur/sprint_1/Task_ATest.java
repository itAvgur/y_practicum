package org.itavgur.sprint_1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_ATest {

    @Test
    public void test() {
        Integer result;

        Integer[] input1 = {-8, -5, -2, 7};
        result = Task_A.process(input1);
        assertEquals(-183, result);

        Integer[] input2 = {8, 2, 9, -10};
        result = Task_A.process(input2);
        assertEquals(40, result);

    }

    @Test
    public void inputTest() {

        String str = "-8 -5 -2 7";
        Integer[] res = Arrays.stream(str.split(" "))
                .map(s -> Integer.parseInt(s))
                .toArray(Integer[]::new);
        System.out.println(res);

    }
}