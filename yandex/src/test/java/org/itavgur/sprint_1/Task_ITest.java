package org.itavgur.sprint_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_ITest {

    @Test
    public void test() {
        String result;

        result = Task_I.process("8");
        assertEquals("False", result);

        result = Task_I.process("15");
        assertEquals("False", result);

        result = Task_I.process("16");
        assertEquals("True", result);

    }

}