package org.itavgur.sprint_6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_BTest {

    @Test
    public void test() {

        Integer[][] expected;
        Integer[][] result;

        Integer[] brief = {5, 3};
        Integer[][] links = {{1, 3}, {2, 3}, {5, 2}};
        expected = new Integer[][]{
                new Integer[]{0, 0, 1, 0, 0},
                new Integer[]{0, 0, 1, 0, 0},
                new Integer[]{0, 0, 0, 0, 0},
                new Integer[]{0, 0, 0, 0, 0},
                new Integer[]{0, 1, 0, 0, 0}
        };
        result = Task_B.process(links, brief);
        assertArrayEquals(expected, result);
    }

}