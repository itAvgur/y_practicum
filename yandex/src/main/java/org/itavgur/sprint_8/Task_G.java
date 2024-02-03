package org.itavgur.sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_G {

    protected static final String DELIMITER = " ";

    protected static Integer[] findSequence(int sizeData, Integer[] data, int sizeTemplate, Integer[] template) {

        List<Integer> res = new ArrayList<>();

        int offset;
        for (int i = 0; i <= data.length - template.length; i++) {
            offset = template[0] - data[i];

            for (int j = 1; j < template.length; j++) {
                if (i + j > data.length) {
                    res.add(i);
                    break;
                }

                if (data[i + j] + offset != template[j]) {
                    break;
                } else if (j + 1 == template.length) {
                    res.add(i + 1);
                }
            }

        }

        return res.toArray(Integer[]::new);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] result = findSequence(readInt(reader), readIntegers(reader), readInt(reader), readIntegers(reader));

            printArrayInLine(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER)).map(Integer::parseInt).toArray(Integer[]::new);
    }

    private static void printArrayInLine(Integer[] data) {
        PrintWriter output = new PrintWriter(System.out);
        for (Integer value : data) {
            output.print(value);
            output.print(DELIMITER);
        }
        output.flush();
        output.close();
    }

}