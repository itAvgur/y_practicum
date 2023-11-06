package org.itavgur.sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_A {

    public static long process(long base, long mod, String str) {

        char[] charArray = str.toCharArray();

        if (charArray.length == 0) return 0;
        if (charArray.length == 1) return charArray[0];

        long hash = 0;
        for (char letter : charArray) {
            hash = (hash * base + letter) % mod;
        }

        return hash;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            long base = readLong(reader);
            long mod = readLong(reader);
            long result = process(base, mod, readString(reader));
            System.out.println(result);
        }
    }

    private static long readLong(BufferedReader reader) throws IOException {
        return Long.parseLong(reader.readLine());
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

}