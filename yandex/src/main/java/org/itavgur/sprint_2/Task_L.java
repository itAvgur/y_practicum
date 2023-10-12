package org.itavgur.sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_L {

    public static int process(Integer[] number) {
        return 0;


    }

    private static int fibonachi(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;

        return fibonachi(number - 1) + fibonachi(number - 2);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Integer result = process(readIntegers(reader));
            System.out.println(result);
        }
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
