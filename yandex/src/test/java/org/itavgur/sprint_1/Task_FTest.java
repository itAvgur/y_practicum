package org.itavgur.sprint_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_FTest {

    @Test
    public void test() {
        String result;

        String input1 = "A man, a plan, a canal: Panama";
        result = Task_F.process(input1);
        assertEquals("True", result);

        String input2 = "zo";
        result = Task_F.process(input2);
        assertEquals("False", result);

    }
}