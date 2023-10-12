package org.itavgur.sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task_H {

    private static final String[] SQUARE_BRACKETS = {"[", "]"};
    private static final String[] ROUND_BRACKETS = {"(", ")"};
    private static final String[] CURLY_BRACKETS = {"{", "}"};

    public static String process(String input) {

        List<String> stack = new ArrayList<>();

        if (input.isBlank()) return "True";

        boolean code = true;

        String[] str = input.split("");
        for (String letter : str) {
            if ("[({".contains(letter)) {
                stack.add(letter);
            } else {
                if (stack.isEmpty()) {
                    code = false;
                    break;
                }
                String last = stack.get(stack.size() - 1);

                if (SQUARE_BRACKETS[1].equals(letter) && last.equals(SQUARE_BRACKETS[0])) {
                    stack.remove(stack.size() - 1);
                } else if (ROUND_BRACKETS[1].equals(letter) && last.equals(ROUND_BRACKETS[0])) {
                    stack.remove(stack.size() - 1);
                } else if (CURLY_BRACKETS[1].equals(letter) && last.equals(CURLY_BRACKETS[0])) {
                    stack.remove(stack.size() - 1);
                } else {
                    code = false;
                    break;
                }
            }
        }

        return stack.isEmpty() && code ? "True" : "False";

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