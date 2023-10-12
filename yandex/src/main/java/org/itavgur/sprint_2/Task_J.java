package org.itavgur.sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Task_J {

    private static final String PUT = "put";
    private static final String GET = "get";
    private static final String SIZE = "size";

    public static String[] process(Integer command, String[] ar) {

        int size = 0;
        Node head = null;
        Node tail = null;
        List<String> res = new ArrayList<>();

        for (String s : ar) {
            String[] row = s.split(" ");

            if (PUT.equals(row[0])) {
                Node newNode = new Node(row[1], null, head);
                if (head == null) {
                    tail = newNode;
                } else {
                    head.prev = newNode;
                }
                head = newNode;
                ++size;

            } else if (GET.equals(row[0])) {
                if (size == 0) {
                    res.add("error");
                } else {
                    Node lastNode = tail;
                    res.add(lastNode.value);
                    if (lastNode.prev == null) {
                        tail = null;
                        head = null;
                    } else {
                        tail = lastNode.prev;
                    }
                    --size;
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
            String[] strings = readStringsPerLine(reader, command);

            String[] result = process(command, strings);
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

    private static class Node {

        String value;
        Node prev;
        Node next;

        public Node(String value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

    }

}