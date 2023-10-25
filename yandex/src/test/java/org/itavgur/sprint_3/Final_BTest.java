package org.itavgur.sprint_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Final_BTest {

    @Test
    public void test() {
        String[] result;
        String[] input;
        String[] expected;

        FinalB finalB = new FinalB();
        input = new String[]{"alla 4 100", "gena 6 1000", "gosha 2 90", "rita 2 90", "timofey 4 80"};
        expected = new String[]{"gena", "timofey", "alla", "gosha", "rita"};
        result = finalB.process(input);
        assertArrayEquals(expected, result);

        finalB = new FinalB();
        input = new String[]{"alla 0 0", "gena 0 0", "gosha 0 0", "rita 0 0", "timofey 0 0"};
        expected = new String[]{"alla", "gena", "gosha", "rita", "timofey"};
        result = finalB.process(input);
        assertArrayEquals(expected, result);

    }
}