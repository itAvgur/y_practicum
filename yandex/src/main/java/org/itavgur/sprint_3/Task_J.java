package org.itavgur.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_J {

    private static final String DELIMITER = " ";

    public static Integer[][] process(Integer[] ar) {

        List<Integer[]> result = new ArrayList<>();
        if (ar.length != 0 && ar.length != 1) {
            int i = 1;
            boolean found = false;
            boolean foundOnce = false;
            while (true) {
                if (ar[i] < ar[i - 1]) {
                    int exch = ar[i - 1];
                    ar[i - 1] = ar[i];
                    ar[i] = exch;
                    found = true;
                    foundOnce = true;
                }
                if (i + 1 == ar.length && found) {
                    result.add(ar.clone());
                    i = 0;
                    found = false;
                }
                if (i + 1 == ar.length && !foundOnce) {
                    result.add(ar.clone());
                    break;
                }
                if (i + 1 == ar.length && !found) break;

                i++;
            }
        }

        Integer[][] resAsArray = new Integer[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            resAsArray[i] = result.get(i);
        }

        return resAsArray;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            readInt(reader);
            Integer[] numbers = readIntegers(reader);
            printMatrix(process(numbers));
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
}