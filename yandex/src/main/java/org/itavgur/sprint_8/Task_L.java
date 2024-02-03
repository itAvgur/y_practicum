package org.itavgur.sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Task_L {

    protected static final String DELIMITER = " ";

    protected static Integer[] prefixFunction(String str) {

        Integer[] result = new Integer[str.length()];
        result[0] = 0;

        for (int i = 1; i < result.length; i++) {

            result[i] = 0;

            int previousResult = result[i - 1];

            while (previousResult > 0 && str.charAt(previousResult) != str.charAt(i)) {
                previousResult = result[previousResult - 1];
            }

            if (str.charAt(previousResult) == str.charAt(i)) {
                result[i] = previousResult + 1;
            }

        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String string = readString(reader);
            printArrayInLine(prefixFunction(string));
        }
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    private static void printArrayInLine(Integer[] data) {
        PrintWriter output = new PrintWriter(System.out);
        for (int value : data) {
            output.print(value);
            output.print(DELIMITER);
        }
        output.flush();
        output.close();
    }

}