package org.itavgur.sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task_F {

    private static String PUSH = "push";
    private static String POP = "pop";
    private static String GET_MAX = "get_max";


    public static String[] process(Integer size, String[] ar) {

        List<Integer> stack = new ArrayList<>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < ar.length; i++) {

            String[] row = ar[i].split(" ");
            if (PUSH.equals(row[0])) {
                stack.add(Integer.parseInt(row[1]));
            } else if (POP.equals(row[0])) {
                if (stack.isEmpty()) {
                    res.add("error");
                } else {
                    stack.remove(stack.size() - 1);
                }
            } else if (GET_MAX.equals(row[0])) {
                if (stack.isEmpty()) {
                    res.add("None");
                } else {
                    res.add("" + Collections.max(stack));
                }
            } else {
                throw new RuntimeException("unknown operation");
            }
        }

        return res.toArray(String[]::new);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int size = readInt(reader);
            String[] strings = readStringsPerLine(reader, size);

            String[] result = process(size, strings);
            printArrayPerLine(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static void printArrayPerLine(String[] strings) {

        for (String string : strings) {
            System.out.println(string);
        }
    }

    private static String[] readStringsPerLine(BufferedReader reader, int size) throws IOException {
        String[] res = new String[size];
        for (int i = 0; i < size; i++) {
            res[i] = reader.readLine();
        }
        return res;
    }

}