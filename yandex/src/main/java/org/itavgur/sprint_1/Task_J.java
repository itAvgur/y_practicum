package org.itavgur.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Task_J {

    public static Integer[] process(Integer number) {

        List<Integer> res = new ArrayList<>();

        for (int i; number > 1; ) {
            int dividor = isPrime(number);
            if (dividor == -1) {
                res.add(number);
                break;
            } else {
                i = dividor;
                res.add(i);
                number = number / i;
            }
        }
        return res.toArray(Integer[]::new);
    }

    private static int isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0)
                return i;
        return -1;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            printArray(process(readInt(reader)));
        }
    }

    private static void printArray(Integer[] integers) {
        StringJoiner res = new StringJoiner(" ");
        for (Integer integer : integers) {
            res.add(integer.toString());
        }
        System.out.println(res);
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}