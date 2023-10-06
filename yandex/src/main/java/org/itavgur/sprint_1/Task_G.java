package org.itavgur.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_G {

    public static String process(Integer number) {
        StringBuilder sb = new StringBuilder();

        if (number == 0) return "0";

        while (number > 0) {
            int c = number / 2;
            int d = number % 2;
            number = c;
            sb.append(d != 0 ? 1 : 0);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer data = readInt(reader);
            String result = process(data);
            System.out.println(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}