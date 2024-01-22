package org.itavgur.sprint_6;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task_J {

    private static final String DELIMITER = " ";

    protected static Integer[] sortTopology(Integer[] data) {

        Node[] graph = initGraph(data);

        for (Node node : graph) {
            makeSearchRecursively(node);
        }

        return Arrays.stream(graph).sorted(Comparator.comparingInt(o -> o.level)).map(e -> e.value + 1).toArray(Integer[]::new);
    }

    private static Node[] initGraph(Integer[] data) {

        int size = data[0];

        Node[] graph = new Node[size];

        for (int i = 0; i < size; i++) {
            graph[i] = buildNewNode(i);
        }

        for (int i = 2; i < data.length; i = i + 2) {
            graph[data[i] - 1].children.add(graph[data[i + 1] - 1]);
        }

        return graph;
    }

    private static Node buildNewNode(int value) {
        Node node = new Node();
        node.value = value;
        node.children = new ArrayList<>();
        node.level = 0;
        return node;
    }

    private static void makeSearchRecursively(Node node) {

        node.level = node.level + 1;
        for (Node sibling : node.children) {
            makeSearchRecursively(sibling);
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] data = readData(reader);
            Integer[] result = sortTopology(data);
            printArrayInLine(result);
        }
    }

    public static Integer[] readData(Reader reader) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(reader);
        List<Integer> tokens = new ArrayList<>();

        int currentToken = streamTokenizer.nextToken();
        while (currentToken != StreamTokenizer.TT_EOF) {

            if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                tokens.add((int) streamTokenizer.nval);
            }

            currentToken = streamTokenizer.nextToken();
        }

        return tokens.toArray(Integer[]::new);
    }

    private static void printArrayInLine(Integer[] values) {
        PrintWriter output = new PrintWriter(System.out);
        for (Integer value : values) {
            output.print(value);
            output.print(DELIMITER);
        }
        output.flush();
        output.close();
    }

    private static class Node implements Comparable<Node> {
        int value;

        List<Node> children;

        int level;

        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }

    }

}