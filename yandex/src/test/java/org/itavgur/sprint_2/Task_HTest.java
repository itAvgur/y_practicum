package org.itavgur.sprint_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_HTest {

    @Test
    public void test1() {
        String result;
        String input;
        String expected;

        input = "";
        result = Task_H.process(input);
        expected = "True";
        assertEquals(expected, result);

        input = "((())";
        result = Task_H.process(input);
        expected = "False";
        assertEquals(expected, result);

        input = "]([(([((({))}])])([({})]}(]))](][}{{";
        result = Task_H.process(input);
        expected = "False";
        assertEquals(expected, result);

        input = "{[()]}";
        result = Task_H.process(input);
        expected = "True";
        assertEquals(expected, result);
    }

}