package org.itavgur.sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Task_C {

    private static final String DELIMITER = " ";

    public static Integer[] process(Integer base, Integer mod, String str, Integer[][] indices) {

        //todo

        return null;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer base = readInt(reader);
            Integer mod = readInt(reader);
            String string = readString(reader);
            Integer strAmount = readInt(reader);
            Integer[] result = process(base, mod, string, readMatrix(reader, strAmount, 2));
            printArrayInLine(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER)).map(Integer::parseInt).toArray(Integer[]::new);
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    protected static Integer[][] readMatrix(BufferedReader reader, int rows, int columns) throws IOException {
        Integer[][] res = new Integer[rows][columns];
        for (int i = 0; i < rows; ++i) {
            Integer[] integers = readIntegers(reader);
            res[i] = integers;
        }
        return res;
    }

    private static void printArrayInLine(Integer[] values) {
        PrintWriter output = new PrintWriter(System.out);
        for (Integer value : values) {
            output.print(value);
            output.print(DELIMITER);
        }
        output.flush();
        output.close();
    }
}