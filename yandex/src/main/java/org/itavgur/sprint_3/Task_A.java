package org.itavgur.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Task_A {

    public static String[] process(Integer number) {

        return BracketsBuilder.process(number);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] result = process(readInt(reader));
            printArray(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static void printArray(String[] values) {
        PrintWriter output = new PrintWriter(System.out);
        for (String value : values) {
            output.println(value);
        }
        output.flush();
        output.close();
    }

    public static class BracketsBuilder {

        private static final String DELIMITER = " ";

        private final StringBuilder sb = new StringBuilder();

        public static String[] process(int number) {
            BracketsBuilder bracketsBuilder = new BracketsBuilder();
            bracketsBuilder.buildStringWithBracket(number * 2, "", 0, 0);
            return bracketsBuilder.sb.toString().trim().split(DELIMITER);
        }

        private void buildStringWithBracket(int n, String prefix, int open, int close) {
            if (n == 0 && open == close) {
                sb.append(prefix);
                sb.append(DELIMITER);
            } else {
                if (open - close <= n) {
                    buildStringWithBracket(n - 1, prefix + "(", open + 1, close);
                }
                if (close < open) {
                    buildStringWithBracket(n - 1, prefix + ")", open, close + 1);
                }
            }
        }
    }

}