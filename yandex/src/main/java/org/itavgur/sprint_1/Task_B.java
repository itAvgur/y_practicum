package org.itavgur.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_B {

    public static String process(Integer[] ar) {
        int firstValue = Math.abs(ar[0] % 2);
        for (Integer i : ar) {
            if (Math.abs(i % 2) != firstValue) return "FAIL";
        }
        return "WIN";
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Integer[] integers = readIntegers(reader);
            String result = process(integers);
            System.out.println(result);
        }
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
