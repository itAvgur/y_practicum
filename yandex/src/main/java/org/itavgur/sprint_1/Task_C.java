package org.itavgur.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Task_C {

    public static Integer[] process(Integer[][] ar, Integer target_x, Integer target_y) {

        List<Integer> res = new ArrayList<>();

        if (target_x - 1 >= 0) {
            res.add(ar[target_x - 1][target_y]);
        }
        if (target_y + 1 < ar[0].length) {
            res.add(ar[target_x][target_y + 1]);
        }
        if (target_x + 1 < ar.length) {
            res.add(ar[target_x + 1][target_y]);
        }
        if (target_y - 1 >= 0) {
            res.add(ar[target_x][target_y - 1]);
        }
        return res.stream().sorted(Integer::compareTo).toArray(Integer[]::new);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer rows = readInt(reader);
            Integer columns = readInt(reader);
            Integer[][] matrix = readMatrix(reader, rows, columns);
            Integer target_x = readInt(reader);
            Integer target_y = readInt(reader);
            Integer[] result = process(matrix, target_x, target_y);
            printArray(result);
        }
    }

    private static void printArray(Integer[] integers) {
        StringJoiner res = new StringJoiner(" ");
        for (Integer integer : integers) {
            res.add(integer.toString());
        }
        System.out.println(res);
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
}
