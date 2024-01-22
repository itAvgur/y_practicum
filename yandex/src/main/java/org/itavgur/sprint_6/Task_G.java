package org.itavgur.sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task_G {

    private static final String DELIMITER = " ";

    protected static Integer maxDistance(Integer[][] links, int size, int head) {

        Node[] graph = new Node[size + 1];
        buildGraph(links, graph, head);

        Node headNode = graph[head];
        headNode.isFinished = true;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(headNode);
        makeSearch(queue);

        return Arrays.stream(graph)
                .filter(Objects::nonNull)
                .mapToInt(value -> value.level).max().getAsInt();
    }

    private static void makeSearch(Queue<Node> queue) {

        while (true) {

            Node node = queue.poll();
            if (node == null) break;

            for (Node sibling : node.siblings) {
                if (!sibling.isFinished) {
                    queue.add(sibling);
                    sibling.isFinished = true;
                    sibling.level = node.level + 1;
                }
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
        node.isFinished = false;
        node.level = 0;
        return node;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] briefInfo = readIntegers(reader);
            Integer[][] links = readMatrix(reader, briefInfo[1], 2);
            Integer head = readInt(reader);

            Integer result = maxDistance(links, briefInfo[0], head);
            System.out.println(result);
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

    public static class Node {

        Integer value;

        List<Node> siblings;

        Boolean isFinished = false;

        int level;

    }

}