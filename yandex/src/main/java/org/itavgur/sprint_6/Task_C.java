package org.itavgur.sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Task_C {

    private static final String DELIMITER = " ";

    private static int count = 0;

    protected static Integer[] dfs(Integer[][] links, int size, int head) {

        Map<Integer, Integer> result = new HashMap<>();

        Node[] graph = new Node[size + 1];
        buildGraph(links, graph, head);
        makeSearchRecursively(graph[head], result);

        return result.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .toArray(Integer[]::new);
    }

    private static void makeSearchRecursively(Node node, Map<Integer, Integer> result) {

        result.put(node.value, count);
        ++count;
        for (Node sibling : node.siblings.stream().sorted().collect(Collectors.toList())) {
            if (!result.containsKey(sibling.value)) {
                makeSearchRecursively(sibling, result);
            }
        }
    }

    private static void buildGraph(Integer[][] links, Node[] graph, int head) {

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

            nodeTo.siblings.add(nodeFrom);
            nodeFrom.siblings.add(nodeTo);
        }

        Node headNode = graph[head];
        if (headNode == null) {
            headNode = buildNewNode(head);
            graph[head] = headNode;
        }
    }

    private static Node buildNewNode(int value) {
        Node node = new Node();
        node.value = value;
        node.siblings = new ArrayList<>();
        return node;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] briefInfo = readIntegers(reader);
            Integer[][] links = readMatrix(reader, briefInfo[1], 2);
            Integer head = readInt(reader);

            Integer[] result = dfs(links, briefInfo[0], head);
            printArrayInLine(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER)).map(Integer::parseInt).toArray(Integer[]::new);
    }

    protected static Integer[][] readMatrix(BufferedReader reader, int rows, int columns) throws IOException {
        Integer[][] res = new Integer[rows][columns];
        for (int i = 0; i < rows; ++i) {
            Integer[] integers = readIntegers(reader);
            res[i] = integers;
        }
        return res;
    }

    private static void printArrayInLine(Integer[] integers) {
        PrintWriter output = new PrintWriter(System.out);
        for (Integer row : integers) {
            output.print(row);
            output.print(DELIMITER);
        }
        output.flush();
        output.close();
    }

    public static class Node implements Comparable<Node> {

        Integer value;

        List<Node> siblings;

        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }
    }

}