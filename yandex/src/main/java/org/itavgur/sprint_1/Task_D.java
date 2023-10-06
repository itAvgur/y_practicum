package org.itavgur.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_D {

    public static Integer process(Integer[] ar) {

        if (ar.length == 1) return 1;

        int counter = 0;

        if (ar[0] > ar[1]) ++counter;
        if (ar[ar.length - 2] < ar[ar.length - 1]) ++counter;

        for (int i = 1; i < ar.length - 1; i++) {
            if (ar[i - 1] < ar[i] && ar[i] > ar[i + 1]) {
                ++counter;
            }
        }
        return counter;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            readInt(reader); // empty operation
            Integer[] data = readIntegers(reader);
            Integer result = process(data);
            System.out.println(result);
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

}
