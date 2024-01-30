package org.itavgur.sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_L {

    private static final String DELIMITER = " ";

    protected static int leprechaunGold(int size, int maxAmount, Integer[] golds) {

        int[][] matrix = new int[2][maxAmount + 1];
        Arrays.fill(matrix[0], 0);

        int previousIdx = 0;
        int currentIdx = 1;

        for (int gold : golds) {
            for (int i = 1; i < matrix[currentIdx].length; i++) {

                matrix[currentIdx][i] = Math.max(
                        matrix[previousIdx][i],
                        ((i >= gold ? gold : 0) + matrix[previousIdx][Math.max(i - gold, 0)])
                );
            }

            previousIdx = (previousIdx + 1) % 2;
            currentIdx = (currentIdx + 1) % 2;
        }

        return matrix[previousIdx][maxAmount];
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] sizes = readIntegers(reader);
            Integer[] data = readIntegers(reader);
            System.out.println(leprechaunGold(sizes[0], sizes[1], data));
        }
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

}