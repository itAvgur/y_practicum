package org.itavgur.sprint_1;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_CTest {

    @Test
    public void test() {

        Integer[][] input3 = {{6, -6, 4}, {1, 4, 9}, {7, -2, -8}, {8, 0, 6}, {9, -2, -5}, {-3, -2, -8}, {10, -10, 3}};
        Integer[] expected3 = {-2, 3, 10};
        assertArrayEquals(expected3, Task_C.process(input3, 6, 1));

        Integer[][] input1 = {{1, 2, 3}, {0, 2, 6}, {7, 4, 1}, {2, 7, 0}};
        Integer[] expected = {7, 7};
        assertArrayEquals(expected, Task_C.process(input1, 3, 0));

        Integer[][] input2 = {{1, 2, 3}, {0, 2, 6}, {7, 4, 1}, {2, 7, 0}};
        Integer[] expected2 = {0, 2};
        assertArrayEquals(expected2, Task_C.process(input2, 0, 0));

    }

    @Test
    public void testMatrix() throws IOException {

        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.when(bufferedReader.readLine())
                .thenReturn("1 2 3")
                .thenReturn("0 2 6")
                .thenReturn("7 4 1")
                .thenReturn("2 7 0");

        Integer[][] matrix = Task_C.readMatrix(bufferedReader, 4, 3);
        Integer[][] expected = {{1, 2, 3}, {0, 2, 6}, {7, 4, 1}, {2, 7, 0}};
        assertArrayEquals(expected, matrix);
    }

}