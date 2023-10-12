package org.itavgur.sprint_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task_KTest {

    @Test
    public void test() {

        assertEquals(3, Task_K.process(3));

        assertEquals(1, Task_K.process(0));

    }

}