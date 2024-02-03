package org.itavgur.sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_H {

    private static final String SENTINEL_SYMBOL = "#";

    protected static String cutPastString(String original, String cut, String paste) {

        String template = cut + SENTINEL_SYMBOL + original;

        Integer[] found = prefixFunction(template);

        StringBuilder sb = new StringBuilder();

        int prefixLength = cut.length() + SENTINEL_SYMBOL.length();
        for (int i = found.length - 1; i >= prefixLength; i--) {

            if (found[i] == cut.length()) {

                for (int j = paste.length() - 1; j >= 0; j--) {
                    sb.append(paste.charAt(j));
                }
                i = i - cut.length() + 1;

            } else {
                sb.append(original.charAt(i - prefixLength));
            }
        }

        return sb.reverse().toString();
    }

    private static Integer[] prefixFunction(String str) {

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

            System.out.println(
                    cutPastString(readString(reader), readString(reader), readString(reader))
            );
        }
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

}