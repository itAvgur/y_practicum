package org.itavgur.sprint_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Final_BTest {

    @Test
    public void test() {
        Integer result;
        String[][] input;

        input = new String[][]{
                {"1", "2", "3", "1"},
                {"2", ".", ".", "2"},
                {"2", ".", ".", "2"},
                {"2", ".", ".", "2"},
        };
        result = Final_B.process(3, input);
        assertEquals(2, result);

        input = new String[][]{
                {"1", "1", "1", "1"},
                {"9", "9", "9", "9"},
                {"1", "1", "1", "1"},
                {"9", "9", "1", "1"},
        };
        result = Final_B.process(4, input);
        assertEquals(1, result);

        input = new String[][]{
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
        };
        result = Final_B.process(4, input);
        assertEquals(0, result);


    }

    @Test
    public void testBad() {


    }
}