package org.itavgur.sprint_7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinalBTest extends FinalB {

    @Test
    public void test1() {

        String expected;
        String result;

        Integer[] input = new Integer[]{1, 5, 7, 1};
        expected = "True";
        result = process(4, input);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {

        String expected;
        String result;

        Integer[] input = new Integer[]{2, 10, 9};
        expected = "False";
        result = process(3, input);
        assertEquals(expected, result);
    }

    @Test
    public void testFailed1() {

        String expected;
        String result;

        Integer[] input = new Integer[]{5, 3, 2, 1, 5};
        expected = "True";
        result = process(6, input);
        assertEquals(expected, result);
    }

    @Test
    public void testFailed2() {

        String expected;
        String result;

        Integer[] input = new Integer[]{243, 169, 158, 96, 146, 237, 300, 10, 39, 287, 281, 38, 103, 264, 81, 33, 259,
                98, 278, 160, 98, 217, 209, 153, 55, 215, 93, 299, 128, 62, 254, 139, 261, 124, 27, 107, 155, 90, 255,
                127, 148, 244, 49, 71, 291, 161, 199, 40, 145, 61, 70, 225, 244, 100, 3, 17, 83, 22, 144, 149, 179, 70,
                153, 90, 232, 1, 247, 218, 61, 9, 42, 151, 190, 243, 256, 154, 28, 20, 18, 152, 146, 59, 132, 134, 165,
                80, 53, 175, 157, 292, 186, 164, 71, 97, 225, 143, 216, 251, 153, 116, 79, 84, 156, 265, 151, 98, 24,
                61, 192, 74, 80, 57, 281, 202, 7, 162, 150, 150, 222, 147, 150, 177, 233, 221, 242, 14, 95, 214, 201,
                15, 144, 18, 143, 129, 266, 195, 77, 230, 189, 67, 196, 101, 235, 106, 289, 149, 260, 258, 35, 254, 33,
                284, 187, 51, 49, 192, 5, 61, 262, 262, 292, 201, 8, 264, 241, 137, 156, 101, 210, 151, 187, 284, 255,
                166, 101, 65, 16, 238, 256, 66, 73, 231, 232, 138, 254, 240, 146, 171, 176};

        expected = "True";
        result = process(190, input);
        assertEquals(expected, result);
    }

}