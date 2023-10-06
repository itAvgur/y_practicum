package org.itavgur.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_F {

    public static String process(String str) {

        char[] chars = str.toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        while (begin < end) {
            while (!Character.isLetterOrDigit(chars[begin])) {
                ++begin;
            }
            while (!Character.isLetterOrDigit(chars[end])) {
                --end;
            }
            if (Character.toLowerCase(chars[begin]) == Character.toLowerCase(chars[end])) {
                ++begin;
                --end;
                continue;
            }
            return "False";
        }
        return "True";
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String data = readString(reader);
            String result = process(data);
            System.out.println(result);
        }
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

}