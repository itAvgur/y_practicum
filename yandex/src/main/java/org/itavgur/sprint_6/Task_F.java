package org.itavgur.sprint_6;

import java.io.*;
import java.util.*;

public class Task_F {

    private static final String DELIMITER = " ";
    private static final int NOT_FOUND_RESULT = -1;

    protected static Integer distanceBetweenNodes(Integer[] data) {

        Node[] graph = buildGraph(data);

        Integer[] targetNodes = new Integer[]{data[data.length - 2], data[data.length - 1]};

        Node fromNode = graph[targetNodes[0]];
        fromNode.distance = 0;
        fromNode.isFinished = true;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(fromNode);
        makeSearch(queue, targetNodes[1]);

        return Arrays.stream(graph)
                .filter(Objects::nonNull)
                .filter(o -> o.value.equals(targetNodes[1]))
                .mapToInt(value -> value.distance).findFirst().orElse(NOT_FOUND_RESULT);
    }

    private static void makeSearch(Queue<Node> queue, int targetNode) {

        while (true) {

            Node node = queue.poll();
            if (node == null) break;

            for (Node sibling : node.siblings) {
                if (!sibling.isFinished) {
                    queue.add(sibling);
                    sibling.isFinished = true;
                    sibling.distance = node.distance + 1;
                }

                if (sibling.value == targetNode) {
                    break;
                }
            }

        }

    }

    private static Node[] buildGraph(Integer[] data) {

        int size = data[0];
        Node[] graph = new Node[size + 1];
        for (int i = 1; i <= size; i++) {
            graph[i] = buildNewNode(i);
        }

        for (int i = 2; i <= data[1] * 2; i = i + 2) {
            graph[data[i]].siblings.add(graph[data[i + 1]]);
            graph[data[i + 1]].siblings.add(graph[data[i]]);
        }

        return graph;
    }

    private static Node buildNewNode(int value) {
        Node node = new Node();
        node.value = value;
        node.siblings = new ArrayList<>();
        node.isFinished = false;
        node.distance = -1;
        return node;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] data = readData(reader);
            Integer result = distanceBetweenNodes(data);
            System.out.println(result);
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

    public static class Node {

        Integer value;

        List<Node> siblings;

        Boolean isFinished = false;

        int distance;

    }

}