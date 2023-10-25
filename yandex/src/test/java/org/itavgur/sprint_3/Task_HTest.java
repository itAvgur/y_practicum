package org.itavgur.sprint_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Task_HTest {

    @Test
    public void test() {

        String result;
        String[] input;
        String expected;

        input = new String[]{"90", "87", "8"};
        result = Task_H.process(3, input);
        expected = "90887";
        Assertions.assertEquals(expected, result);

        input = new String[]{"9", "10", "1", "1", "1", "6"};
        result = Task_H.process(6, input);
        expected = "9611110";
        Assertions.assertEquals(expected, result);

        input = new String[]{"15", "56", "2"};
        result = Task_H.process(3, input);
        expected = "56215";
        Assertions.assertEquals(expected, result);

        input = new String[]{"1", "783", "2"};
        result = Task_H.process(3, input);
        expected = "78321";
        Assertions.assertEquals(expected, result);

        input = new String[]{"2", "4", "5", "2", "10"};
        result = Task_H.process(5, input);
        expected = "542210";
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void testSortString() {

        String[] array = {"1", "783", "2"};
        List<String> list = Arrays.stream(array).toList().stream().sorted().toList();

        System.out.println(list);
    }
}