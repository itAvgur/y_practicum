package org.itavgur.sprint_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task_MTest extends Task_M {

    @Test
    public void test() {
        int[] sample = {-1, 12, 6, 8, 3, 15, 7};
        Assertions.assertEquals(1, siftUp(sample, 5));
    }

}