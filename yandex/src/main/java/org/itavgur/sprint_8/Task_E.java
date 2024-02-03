package org.itavgur.sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Task_E {

    protected static final String DELIMITER = " ";

    protected static String insertString(String original, int numbers, NewString[] newStrings) {

        StringBuilder sb = new StringBuilder();

        int startIdx = 0;
        for (NewString newString : Arrays.stream(newStrings).sorted().collect(Collectors.toList())) {
            sb.append(original, startIdx, newString.position);
            sb.append(newString.text);
            startIdx = startIdx + (newString.position - startIdx);
        }

        sb.append(original, startIdx, original.length());

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String originalString = readString(reader);
            int numbers = readInt(reader);
            NewString[] newStrings = readMatrix(reader, numbers);
            System.out.println(insertString(originalString, numbers, newStrings));
        }
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static String[] readStrings(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .toArray(String[]::new);
    }

    private static NewString[] readMatrix(BufferedReader reader, int rows) throws IOException {
        NewString[] res = new NewString[rows];
        for (int i = 0; i < rows; ++i) {
            String[] integers = readStrings(reader);
            res[i] = new NewString(integers[0], Integer.parseInt(integers[1]));
        }
        return res;
    }

    protected static class NewString implements Comparable<NewString> {

        String text;
        int position;

        public NewString(String text, int position) {
            this.text = text;
            this.position = position;
        }

        @Override
        public int compareTo(NewString o) {
            return this.position - o.position;
        }
    }

}