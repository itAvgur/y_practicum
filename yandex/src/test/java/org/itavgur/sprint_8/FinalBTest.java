package org.itavgur.sprint_8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinalBTest extends FinalB {

    @Test
    public void test1() {

        String expected;
        String result;

        String text = "examiwillpasstheexam";
        String[] words = {"will", "pass", "the", "exam", "i"};
        expected = POSITIVE_ANSWER;
        result = process(text,  5, words);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {

        String expected;
        String result;

        String text = "abacaba";
        String[] words = {"abac", "caba"};
        expected = NEGATIVE_ANSWER;
        result = process(text,  2, words);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {

        String expected;
        String result;

        String text = "abacaba";
        String[] words = {"abac", "caba", "aba"};
        expected = POSITIVE_ANSWER;
        result = process(text, 3, words);
        assertEquals(expected, result);
    }

    @Test
    public void test4() {

        String expected;
        String result;

        String text = "abacabaf";
        String[] words = {"ab", "aba", "abac", "f"};
        expected = POSITIVE_ANSWER;
        result = process(text, 4, words);
        assertEquals(expected, result);
    }

    @Test
    public void testFailed1() {

        String expected;
        String result;

        String text = "bwvfbtrjqpbwvfbbwvbwbbwbbwvbwvf";
        String[] words = {"bwvf", "b", "bw", "bwf"};
        expected = NEGATIVE_ANSWER;
        result = process(text, 4, words);
        assertEquals(expected, result);
    }

    @Test
    public void test5() {

        String expected;
        String result;

        String text = "aaaa";
        String[] words = {"b", "aa"};
        expected = POSITIVE_ANSWER;
        result = process(text, 2, words);
        assertEquals(expected, result);
    }

}