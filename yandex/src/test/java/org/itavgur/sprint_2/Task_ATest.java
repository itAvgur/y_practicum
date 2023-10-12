package org.itavgur.sprint_2;

import org.junit.jupiter.api.Test;

import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_ATest {

    private static void printArrayPerLine(Integer[][] array) {
        PrintWriter output = new PrintWriter(System.out);
        for (Integer[] row : array) {
            for (int i = 0; i < row.length; i++) {
                output.print(row[i]);
                if (i + 1 != row.length) {
                    output.print(" ");
                }
            }
            output.println();
        }
        output.flush();
        output.close();
    }

    @Test
    public void test1() {
        Integer[][] result;
        Integer[][] input;
        Integer[][] expected;

        expected = new Integer[][]{{1, 0, 7, 2}, {2, 2, 4, 7}, {3, 6, 1, 0}};
        input = new Integer[][]{{1, 2, 3}, {0, 2, 6}, {7, 4, 1}, {2, 7, 0}};
        result = Task_A.process(4, 3, input);
        assertArrayEquals(expected, result);


        input = new Integer[][]{{-7, -1, 0, -4, -9}, {5, -1, 2, 2, 9}, {3, 1, -8, -1, -7}, {9, 0, 8, -8, -1},
                {2, 4, 5, 2, 8}, {-7, 10, 0, -4, -8}, {-3, 10, -7, 10, 3}, {1, 6, -7, -5, 9}, {-1, 9, 9, 1, 9}};
        result = Task_A.process(9, 5, input);
        expected = new Integer[][]{{-7, 5, 3, 9, 2, -7, -3, 1, -1}, {-1, -1, 1, 0, 4, 10, 10, 6, 9},
                {0, 2, -8, 8, 5, 0, -7, -7, 9}, {-4, 2, -1, -8, 2, -4, 10, -5, 1}, {-9, 9, -7, -1, 8, -8, 3, 9, 9}};
        assertArrayEquals(expected, result);

    }

    @Test
    public void test2() {
        Integer[][] res = new Integer[][]{{-7, 5, 3, 9, 2, -7, -3, 1, -1}, {-1, -1, 1, 0, 4, 10, 10, 6, 9},
                {0, 2, -8, 8, 5, 0, -7, -7, 9}, {-4, 2, -1, -8, 2, -4, 10, -5, 1}, {-9, 9, -7, -1, 8, -8, 3, 9, 9}};
        printArrayPerLine(res);

    }
}