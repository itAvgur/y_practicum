package org.itavgur.sprint_4;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_CTest {

    @Test
    @Disabled
    public void test() {

        Integer[] expected;
        Integer[] result;
        Integer[][] indices;

        indices = new Integer[][]{{1, 1}, {1, 5}, {2, 3}, {3, 4}, {4, 4}, {1, 8}, {5, 8}};
        result = Task_C.process(1000, 1000009, "abcdefgh", indices);
        expected = new Integer[]{97, 225076, 98099, 99100, 100, 436420, 193195};
        assertEquals(expected, result);

        indices = new Integer[][]{{1, 1}};
        result = Task_C.process(100, 10, "a", indices);
        expected = new Integer[]{7};
        assertEquals(expected, result);

    }
}