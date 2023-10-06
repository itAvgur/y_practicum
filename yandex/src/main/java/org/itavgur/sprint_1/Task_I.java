package org.itavgur.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_I {

    public static String process(String str) {

        int num = Integer.parseInt(str);

        while (num != 1) {
            if (num % 4 > 0 || num < 4) return "False";
            num = num / 4;
        }
        return "True";
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String result = process(readString(reader));
            System.out.println(result);
        }
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

}