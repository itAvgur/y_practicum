package org.itavgur.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_C {

    public static Boolean process(String str1, String str2) {

        char[] shortStr;
        char[] longStr;
        shortStr = str1.toCharArray();
        longStr = str2.toCharArray();
        int foundCount = 0;
        boolean found;
        int startIdxInLong = 0;

        for (int i = 0; i < shortStr.length; i++) {
            found = false;
            for (int j = startIdxInLong; j < longStr.length; j++) {
                if (shortStr[i] == longStr[j]) {
                    ++foundCount;
                    found = true;
                    startIdxInLong = j + 1;
                    break;
                }
            }
            if (!found) {
                break;
            }
        }

        return foundCount == shortStr.length;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Boolean result = process(readString(reader), readString(reader));
            System.out.println(result ? "True" : "False");
        }
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

}