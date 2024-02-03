package org.itavgur.sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;

public class Task_A {

    protected static final String DELIMITER = " ";

    protected static String stringReverse(String[] strings) {


        StringJoiner sj = new StringJoiner(DELIMITER);

        for (int i = strings.length - 1; i >= 0; i--) {
            sj.add(strings[i]);
        }

        return sj.toString();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] data = readStrings(reader);
            System.out.println(stringReverse(data));
        }
    }

    private static String[] readStrings(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .toArray(String[]::new);
    }

}