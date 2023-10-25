package org.itavgur.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Task_L {

    private static final String DELIMITER = " ";
    private static final Integer AMOUNT = 2;

    public static Integer[] process(Integer[] money, Integer cost) {

        Integer[] result = new Integer[AMOUNT];

        for (int i = 1; i <= AMOUNT; ++i) {
            Integer positionFound = binarySearch(money, cost * i, 0, money.length - 1, -1);
            result[i - 1] = positionFound == -1 ? -1 : positionFound + 1;
        }

        return result;
    }

    private static Integer binarySearch(Integer[] money, Integer cost, int startIdx, int endIdx, int lastPosition) {

        int position = (endIdx + startIdx) / 2;
        Integer haveMoney = money[position];
        if (haveMoney < cost) {
            if (startIdx == endIdx) return lastPosition;
            return binarySearch(money, cost, position + 1, endIdx, lastPosition);
        } else {
            lastPosition = position;
            if (startIdx == endIdx) return lastPosition;
            return binarySearch(money, cost, startIdx, position, lastPosition);
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            readInt(reader);
            Integer[] money = readIntegers(reader);
            Integer cost = readInt(reader);
            Integer[] result = process(money, cost);
            printArray(result);
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

    private static void printArray(Integer[] values) {
        PrintWriter output = new PrintWriter(System.out);
        for (Integer value : values) {
            output.print(value);
            output.print(DELIMITER);
        }
        output.flush();
        output.close();
    }
}