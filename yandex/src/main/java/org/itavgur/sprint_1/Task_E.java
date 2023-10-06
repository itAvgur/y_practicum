package org.itavgur.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_E {

    public static String process(String[] ar, Integer days) {

        String res = "";
        for (String word : ar) {
            if (res.length() < word.length()) {
                res = word;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer days = readInt(reader);
            String[] data = readStrings(reader);
            String result = process(data, days);
            System.out.println(result);
            System.out.println(result.length());
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
