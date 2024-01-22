package org.itavgur.sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Task_B {

    private static final String DELIMITER = " ";

    protected static Integer[][] process(Integer[][] links, Integer[] briefInfo) {

        Integer[][] res = initMatrix(briefInfo[0]);

        for (int i = 0; i < links.length; i++) {
            int from = links[i][0] - 1;
            int to = links[i][1] - 1;
            res[from][to] = res[from][to] + 1;
        }

        return res;
    }

    private static Integer[][] initMatrix(int size) {
        Integer[][] res = new Integer[size][size];

        for (int i = 0; i < res.length; i++) {
            Integer[] newRow = new Integer[size];
            Arrays.fill(newRow, 0);

            res[i] = newRow;
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] briefInfo = readIntegers(reader);
            Integer[][] links = readMatrix(reader, briefInfo[1], 2);

            Integer[][] result = process(links, briefInfo);
            printMatrixPerLine(result);
        }
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

    private static void printMatrixPerLine(Integer[][] array) {
        PrintWriter output = new PrintWriter(System.out);
        for (Integer[] row : array) {
            for (int i = 0; i < row.length; i++) {
                output.print(row[i]);
                output.print(DELIMITER);
            }
            output.println();
        }
        output.flush();
        output.close();
    }

}