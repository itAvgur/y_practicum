package org.itavgur.sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_K {

    public static int process(int number) {

        return fibonachi(number + 1);
    }

    private static int fibonachi(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;

        return fibonachi(number - 1) + fibonachi(number - 2);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Integer result = process(readInt(reader));
            System.out.println(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
