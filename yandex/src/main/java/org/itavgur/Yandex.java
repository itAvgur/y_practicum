package org.itavgur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Yandex {

    private static final String DELIMITER = " ";

    public static int process(Integer[] list) {


        return 3;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            //nothing here

        }
    }

    private static void printArrayPerLine(String[] strings) {
        PrintWriter output = new PrintWriter(System.out);
        for (String string : strings) {
            output.println(string);
        }
        output.flush();
        output.close();
    }

    private static void printArrayInLine(String[] strings) {
        PrintWriter output = new PrintWriter(System.out);
        for (String string : strings) {
            output.print(string);
            output.print(DELIMITER);
        }
        output.flush();
        output.close();
    }

    private static void printMatrixPerLine(Integer[][] array) {
        PrintWriter output = new PrintWriter(System.out);
        for (Integer[] row : array) {
            for (int i = 0; i < row.length; i++) {
                output.print(row[i]);
                if (i + 1 != row.length) {
                    output.print(DELIMITER);
                }
            }
            output.println();
        }
        output.flush();
        output.close();
    }

    private static void printMatrix(Integer[][] values) {
        PrintWriter output = new PrintWriter(System.out);
        for (Integer[] row : values) {
            for (Integer value : row) {
                output.print(value);
                output.print(DELIMITER);
            }
            output.println();
        }
        output.flush();
        output.close();
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER))
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

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    private static String[] readStrings(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .toArray(String[]::new);
    }

    private static String[] readStrings(BufferedReader reader, int rows) throws IOException {
        String[] res = new String[rows];
        for (int i = 0; i < rows; ++i) {
            String value = readString(reader);
            res[i] = value;
        }
        return res;
    }

}