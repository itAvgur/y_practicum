package org.itavgur.sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Task_E {

    private static final String DELIMITER = " ";

    protected static Integer[][] process(Integer[][] links, Integer[] briefInfo) {

        Node[] graph = initGraph(briefInfo[0], links);

        int componentNumber = 1;

        for (Node node : graph) {
            makeSearchRecursively(node, componentNumber);
            ++componentNumber;
        }

        List<List<Node>> map = Arrays.stream(graph)
                .collect(groupingBy(o -> o.componentNumber)).values()
                .stream().sorted(Comparator.comparingInt(o -> o.get(0).value))
                .collect(Collectors.toList());

        Integer[][] result = new Integer[map.size() + 1][];
        result[0] = new Integer[]{map.size()};

        int counter = 1;
        for (List<Node> nodes : map) {
            result[counter] = nodes.stream()
                    .map(node -> node.value + 1)
                    .toArray(Integer[]::new);
            counter++;
        }

        return result;
    }

    private static Node[] initGraph(int size, Integer[][] links) {

        Node[] graph = new Node[size];

        for (int i = 0; i < size; i++) {
            graph[i] = buildNewNode(i);
        }

        for (Integer[] link : links) {
            graph[link[0] - 1].siblings.add(graph[link[1] - 1]);
            graph[link[1] - 1].siblings.add(graph[link[0] - 1]);
        }

        return graph;
    }

    private static Node buildNewNode(int value) {
        Node node = new Node();
        node.value = value;
        node.siblings = new ArrayList<>();
        node.componentNumber = 0;
        return node;
    }

    private static void makeSearchRecursively(Node node, int componentNumber) {

        if (node.componentNumber != 0) return;

        node.componentNumber = componentNumber;
        for (Node sibling : node.siblings) {
            makeSearchRecursively(sibling, componentNumber);
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] briefInfo = readIntegers(reader);
            Integer[][] links = readMatrix(reader, briefInfo[1], 2);

            Integer[][] result = process(links, briefInfo);
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

        List<Node> siblings;

        int componentNumber;

        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }

    }

}