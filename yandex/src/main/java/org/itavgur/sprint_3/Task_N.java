package org.itavgur.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task_N {

    public static Integer[][] process(Integer number, Integer[][] flowerbed) {

        Arrays.sort(flowerbed, Comparator.comparingInt(a -> a[0]));

        List<Integer[]> results = new ArrayList<>();

        Integer beginIdx = flowerbed[0][0];
        Integer endIdx = flowerbed[0][1];

        for (int i = 1; i < flowerbed.length; i++) {
            Integer currBeginIdx = flowerbed[i][0];
            Integer currEndIdx = flowerbed[i][1];

            if (currBeginIdx >= beginIdx && currBeginIdx <= endIdx) {

                endIdx = endIdx > currEndIdx ? endIdx : currEndIdx;

            } else {
                results.add(new Integer[]{beginIdx, endIdx});
                beginIdx = currBeginIdx;
                endIdx = currEndIdx;
            }

        }

        results.add(new Integer[]{beginIdx, endIdx});

        return results.stream().sorted(Comparator.comparingInt(o -> o[0])).toArray(Integer[][]::new);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Integer rows = readInt(reader);
            Integer[][] data = readMatrix(reader, rows, 2);
            Integer[][] result = process(rows, data);
            printMatrix(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    protected static Integer[][] readMatrix(BufferedReader reader, int rows, int columns) throws IOException {
        Integer[][] res = new Integer[rows][columns];
        for (int i = 0; i < rows; ++i) {
            Integer[] integers = readIntegers(reader);
            res[i] = integers;
        }
        return res;
    }

    private static void printMatrix(Integer[][] values) {
        PrintWriter output = new PrintWriter(System.out);
        for (Integer[] row : values) {
            for (Integer value : row) {
                output.print(value);
                output.print(" ");
            }
            output.println();
        }
        output.flush();
        output.close();
    }
}