package org.itavgur.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_H {

    public static String process(Integer value, String[] ar) {

        for (int i = 0; i < value - 1; i++) {
            for (int j = 0; j < value - i - 1; j++) {
                String var1 = ar[j] + ar[j + 1];
                String var2 = ar[j + 1] + ar[j];
                if (var1.compareTo(var2) < 0) {
                    String temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
            }
        }

        return Arrays.stream(ar).reduce((s1, s2) -> s1 + s2).get();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Integer number = readInt(reader);
            String[] numbers = readStrings(reader);
            String result = process(number, numbers);
            System.out.println(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static String[] readStrings(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .toArray(String[]::new);
    }
}