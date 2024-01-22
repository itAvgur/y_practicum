package org.itavgur.sprint_6;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_JTest extends Task_J {

    @Test
    public void test1() {

        Integer[] expected;
        Integer[] result;

        Integer[] data = {5, 3, 3, 2, 3, 4, 2, 5};
        expected = new Integer[]{1, 3, 2, 4, 5};
        result = sortTopology(data);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {

        Integer[] expected;
        Integer[] result;

        Integer[] data = {6, 3, 6, 4, 4, 1, 5, 1};
        expected = new Integer[]{2, 3, 5, 6, 4, 1};
        result = sortTopology(data);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test3() {

        Integer[] expected;
        Integer[] result;

        Integer[] data = {4, 0};
        expected = new Integer[]{1, 2, 3, 4};
        result = sortTopology(data);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testStreamTokenizer() throws IOException {

        Integer[] result = readData(new StringReader("5 3\\n 3 2\\n 3 4\\n 2 5\\n"));

        Integer[] expected = new Integer[]{5, 3, 3, 2, 3, 4, 2, 5};
        assertArrayEquals(expected, result);
    }

}