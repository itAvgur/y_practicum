package org.itavgur.sprint_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_BTest {

    @Test
    public void test() {

        String[] expected;
        String[] result;

        result = Task_B.process("23");
        expected = new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        assertArrayEquals(expected, result);

        result = Task_B.process("92");
        expected = new String[]{"wa", "wb", "wc", "xa", "xb", "xc", "ya", "yb", "yc", "za", "zb", "zc"};
        assertArrayEquals(expected, result);
    }

}