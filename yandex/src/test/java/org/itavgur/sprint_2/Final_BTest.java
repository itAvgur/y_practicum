package org.itavgur.sprint_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Final_BTest {

    @Test
    public void test1() {
        Integer result;
        String[] input;
        FinalB finalB;

        finalB = new FinalB();
        input = new String[]{"4", "13", "5", "/", "+"};
        result = finalB.process(input);
        assertEquals(6, result);

        finalB = new FinalB();
        input = new String[]{"2", "5", "-", "4", "/"};
        result = finalB.process(input);
        assertEquals(-1, result);

        finalB = new FinalB();
        input = new String[]{"1", "2"};
        result = finalB.process(input);
        assertEquals(2, result);

        finalB = new FinalB();
        input = new String[]{"7", "2", "+", "4", "*", "2", "+"};
        result = finalB.process(input);
        assertEquals(38, result);

        finalB = new FinalB();
        input = new String[]{"2", "1", "+", "3", "*"};
        result = finalB.process(input);
        assertEquals(9, result);

    }

}