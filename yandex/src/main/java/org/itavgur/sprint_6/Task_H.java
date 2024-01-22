package org.itavgur.sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task_H {

    private static final String DELIMITER = " ";

    private static int counter;

    protected static Integer[][] dfsClassified(Integer[][] links, Integer[] briefInfo) {

        Node[] graph = initGraph(briefInfo[0], links);

        makeSearchRecursively(graph[1]);

        Integer[][] res = new Integer[briefInfo[0]][2];
        for (int i = 1; i < graph.length; i++) {
            res[i - 1] = new Integer[2];
            res[i - 1][0] = graph[i].entry;
            res[i - 1][1] = graph[i].exit;
        }

        return res;
    }

    private static Node[] initGraph(int size, Integer[][] links) {

        counter = 0;

        Node[] graph = new Node[size + 1];

        if (links.length == 0) {
            graph[1] = buildNewNode(1);
            return graph;
        }

        for (Integer[] link : links) {
            Node nodeFrom = graph[link[0]];
            if (nodeFrom == null) {
                nodeFrom = buildNewNode(link[0]);
                graph[link[0]] = nodeFrom;
            }
            Node nodeTo = graph[link[1]];
            if (nodeTo == null) {
                nodeTo = buildNewNode(link[1]);
                graph[link[1]] = nodeTo;
            }

            nodeFrom.siblings.add(nodeTo);
        }
        return graph;
    }

    private static Node buildNewNode(int value) {
        Node node = new Node();
        node.value = value;
        node.siblings = new ArrayList<>();
        return node;
    }

    private static void makeSearchRecursively(Node node) {

        node.entry = counter;
        ++counter;
        for (Node sibling : node.siblings.stream().sorted().collect(Collectors.toList())) {
            if (sibling.entry == null) { //base case
                makeSearchRecursively(sibling);
            }
        }

        node.exit = counter;
        ++counter;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] briefInfo = readIntegers(reader);
            Integer[][] links = readMatrix(reader, briefInfo[1], 2);

            Integer[][] result = dfsClassified(links, briefInfo);
            printMatrixPerLine(result);
        }
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    protected static Integer[][] readMatrix(BufferedReader reader, int rows, int columns) throws IOException {
        Integer[][] res = new Integer[rows][columns];
        for (int i = 0; i < rows; ++i) {
            Integer[] integers = readIntegers(reader);
            res[i] = integers;
        }
        return res;
    }

    private static void printMatrixPerLine(Integer[][] array) {
        PrintWriter output = new PrintWriter(System.out);
        for (Integer[] row : array) {
            for (int i = 0; i < row.length; i++) {
                output.print(row[i]);
                output.print(DELIMITER);
            }
            output.println();
        }
        output.flush();
        output.close();
    }

    private static class Node implements Comparable<Node> {
        int value;

        Integer entry;
        Integer exit;

        List<Node> siblings;

        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }

    }
}