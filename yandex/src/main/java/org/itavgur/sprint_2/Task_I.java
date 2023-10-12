package org.itavgur.sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Task_I {

    private static final String PUSH = "push";
    private static final String POP = "pop";
    private static final String PEEK = "peek";
    private static final String SIZE = "size";

    public static String[] process(Integer command, Integer maxQueue, String[] ar) {

        String[] queue = new String[maxQueue];
        int head = 0;
        int tail = 0;
        int size = 0;
        List<String> res = new ArrayList<>();

        for (String s : ar) {
            String[] row = s.split(" ");
            if (PUSH.equals(row[0])) {
                if (size == maxQueue) {
                    res.add("error");
                } else {
                    queue[head] = row[1];
                    head = (head + 1) % maxQueue;
                    ++size;
                }
            } else if (POP.equals(row[0])) {
                if (size == 0) {
                    res.add("None");
                } else {
                    res.add(queue[tail]);
                    tail = (tail + 1) % maxQueue;
                    --size;
                }
            } else if (PEEK.equals(row[0])) {
                if (size == 0) {
                    res.add("None");
                } else {
                    res.add(queue[tail]);
                }
            } else if (SIZE.equals(row[0])) {
                res.add("" + size);
            } else {
                throw new RuntimeException("unknown operation");
            }
        }

        return res.toArray(String[]::new);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int command = readInt(reader);
            int maxQueue = readInt(reader);
            String[] strings = readStringsPerLine(reader, command);

            String[] result = process(command, maxQueue, strings);
            printArrayPerLine(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static void printArrayPerLine(String[] strings) {
        PrintWriter output = new PrintWriter(System.out);
        for (String string : strings) {
            output.println(string);
        }
        output.flush();
        output.close();
    }

    private static String[] readStringsPerLine(BufferedReader reader, int size) throws IOException {
        String[] res = new String[size];
        for (int i = 0; i < size; i++) {
            res[i] = reader.readLine();
        }
        return res;
    }

}