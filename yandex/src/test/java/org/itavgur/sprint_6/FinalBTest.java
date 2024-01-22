package org.itavgur.sprint_6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinalBTest extends FinalB {

    @Test
    public void test1() {

        String[] input;
        String expected;
        String result;

        input = new String[]{"RB", "R"};
        expected = "NO";
        result = process(3, input);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {

        String[] input;
        String expected;
        String result;

        input = new String[]{"BBB", "RB", "B"};
        expected = "YES";
        result = process(4, input);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {

        String[] input;
        String expected;
        String result;

        input = new String[]{"RRRB", "BRR", "BR", "R"};
        expected = "NO";
        result = process(5, input);
        assertEquals(expected, result);
    }

    @Test
    public void testFailed1() {

        String[] input;
        String expected;
        String result;

        input = new String[]{"RRBRRBRRR", "BBBBBBRB", "BBRBRRR", "RRBRRR", "RBRRR", "BBRR", "RRR", "RR", "B"};
        expected = "YES";
        result = process(10, input);
        assertEquals(expected, result);
    }

    @Test
    public void testFailed2() {

        String[] input;
        String expected;
        String result;

        input = new String[]{"RRBBRRBRR", "RRBBBBRR", "RRBRRRB", "RRRRBR", "BBBBB", "RRBB", "BBR", "RB", "B"};
        expected = "NO";
        result = process(10, input);
        assertEquals(expected, result);
    }

    @Test
    public void testFailed3() {

        String[] input;
        String expected;
        String result;

        input = new String[]{"BBRRR", "BRRR", "RRR", "BR", "B"};
        expected = "NO";
        result = process(6, input);
        assertEquals(expected, result);
    }

}