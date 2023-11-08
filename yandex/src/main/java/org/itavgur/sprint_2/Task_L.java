package org.itavgur.sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_L {

    public static double process(Integer[] number) {

        double value = nthFibonacciTerm(number[0] + 1);
        return ("" + value).length() < number[1] ? value : format(value, number[1]);
    }

    public static double nthFibonacciTerm(int n) {

        double pow = Math.pow(5, 0.5);
        double a = (1 + (pow)) / 2;
        double b = (1 - (pow)) / 2;

        double v = Math.pow(a, n) - Math.pow(b, n);
        return Math.floor(v / pow);
    }

    private static double format(double value, int integer) {

        return value % Math.pow(10, integer);
    }


    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            double result = process(readIntegers(reader));
            System.out.println(result);
        }
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

}
