package org.itavgur.sprint_5;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FinalATest extends Task_K {

    @Test
    public void test() throws IOException {

        String[] result;
        String[] input;
        String[] expected;

        FinalA finalA = new FinalA();
        input = new String[]{"alla 4 100", "gena 6 1000", "gosha 2 90", "rita 2 90", "timofey 4 80"};
        expected = new String[]{"gena", "timofey", "alla", "gosha", "rita"};
        result = finalA.process(input);
        assertArrayEquals(expected, result);

        finalA = new FinalA();
        input = new String[]{"alla 0 0", "gena 0 0", "gosha 0 0", "rita 0 0", "timofey 0 0"};
        expected = new String[]{"alla", "gena", "gosha", "rita", "timofey"};
        result = finalA.process(input);
        assertArrayEquals(expected, result);
    }

}