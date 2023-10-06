package org.itavgur.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_A {

    public static int process(Integer[] ar) {
// y = ax2 + bx + c.
// a x b c
        return ar[0] * ar[1] * ar[1] + ar[2] * ar[1] + ar[3];
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Integer[] integers = readIntegers(reader);
            Integer result = process(integers);
            System.out.println(result);
        }
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
