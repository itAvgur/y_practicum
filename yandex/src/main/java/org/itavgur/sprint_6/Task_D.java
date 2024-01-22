package org.itavgur.sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Task_D {

    private static final String DELIMITER = " ";

    protected static Integer[] bfs(Integer[][] links, int size, int head) {

        Node[] graph = new Node[size + 1];
        buildGraph(links, graph, head);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(graph[head].value);
        graph[head].isFinished = true;

        makeSearch(queue, graph, 0);

        return Arrays.stream(graph)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(o -> o.distance))
                .map(o -> o.value)
                .toArray(Integer[]::new);
    }

    private static void makeSearch(Queue<Integer> queue, Node[] graph, int level) {

        while (true) {

            Integer nodeValue = queue.poll();
            if (nodeValue == null) break;

            Node node = graph[nodeValue];
            node.distance = level;


            for (Integer sibling : node.siblings) {
                if (!graph[sibling].isFinished) {
                    queue.add(sibling);
                    graph[sibling].isFinished = true;
                }
            }

            ++level;
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

            nodeTo.siblings.add(nodeFrom.value);
            nodeFrom.siblings.add(nodeTo.value);
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
        node.siblings = new TreeSet<>();
        return node;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] briefInfo = readIntegers(reader);
            Integer[][] links = readMatrix(reader, briefInfo[1], 2);
            Integer head = readInt(reader);

            Integer[] result = bfs(links, briefInfo[0], head);
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

    public static class Node {

        Integer value;

        SortedSet<Integer> siblings;

        Boolean isFinished = false;

        int distance;

    }

}