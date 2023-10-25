package org.itavgur.sprint_3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Task_KTest {

    @Test
    public void test() {
        int[] c = {1, 4, 2, 10, 1, 2};
        Task_K.merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert Arrays.equals(c, expected2);

        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = Task_K.merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);
    }

    @Test
    public void testFailed() {
        int[] c = {80, 88, 71, 98, 17, 39, 56, 30};
        Task_K.merge_sort(c, 0, 8);
        int[] expected2 = {17, 30, 39, 56, 71, 80, 88, 98};
        assert Arrays.equals(c, expected2);
    }
}