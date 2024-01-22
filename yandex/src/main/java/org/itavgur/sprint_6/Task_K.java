package org.itavgur.sprint_6;

import java.io.*;
import java.util.*;

public class Task_K {

    private static final String DELIMITER = " ";
    private static final int NOT_VISITED = -1;

    protected static Integer[][] sightseeing(Integer[] data) {

        Node[] graph = initGraph(data);
        Integer size = data[0];

        ResultSet[] resultMatrix = new ResultSet[size];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < resultMatrix.length; i++) {
            ResultSet resultSet = new ResultSet(graph[i + 1], size);
            queue.offer(graph[i + 1]);
            resultSet.distance[i] = 0;
            resultSet.visited[i] = true;
            resultMatrix[i] = resultSet;
            dijkstraSearch(queue, resultMatrix, graph);
        }

        return Arrays.stream(resultMatrix)
                .map(o -> o.distance)
                .toArray(Integer[][]::new);
    }

    private static void dijkstraSearch(Queue<Node> queue, ResultSet[] resultMatrix, Node[] graph) {

        Node initialNode = queue.element();

        while (true) {
            Node node = queue.poll();
            if (node == null) break;

            ResultSet resultSet = resultMatrix[initialNode.value - 1];

            for (Distance sibling : node.siblings) {
                int siblingIdx = sibling.node.value - 1;
                //relaxation
                int oldDistance = resultSet.distance[siblingIdx];
                int newDistance = resultSet.distance[node.value - 1] + sibling.distance;
                if (oldDistance == NOT_VISITED || oldDistance > newDistance) {
                    resultSet.distance[siblingIdx] = newDistance;
                    resultSet.parent[siblingIdx] = node;
                }
            }
            //push to query
            Integer candidateIdx = null;
            Integer minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < resultSet.distance.length; i++) {
                if (!resultSet.visited[i] && resultSet.distance[i] != NOT_VISITED && resultSet.distance[i] < minDistance) {
                    candidateIdx = i;
                    minDistance = resultSet.distance[i];
                }
            }
            if (candidateIdx != null) {
                queue.offer(graph[candidateIdx + 1]);
                resultSet.visited[candidateIdx] = true;
            }
        }

    }

    private static Node[] initGraph(Integer[] data) {

        int size = data[0];
        Node[] graph = new Node[size + 1];
        for (int i = 1; i <= size; i++) {
            graph[i] = buildNewNode(i);
        }

        for (int i = 2; i <= data[1] * 3; i = i + 3) {
            graph[data[i]].siblings.add(new Distance(graph[data[i + 1]], data[i + 2]));
            graph[data[i + 1]].siblings.add(new Distance(graph[data[i]], data[i + 2]));
        }

        return graph;
    }

    private static Node buildNewNode(int value) {
        Node node = new Node();
        node.value = value;
        node.siblings = new ArrayList<>();
        return node;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] data = readData(reader);
            Integer[][] result = sightseeing(data);
            printMatrixPerLine(result);
        }
    }

    private static Integer[] readData(Reader reader) throws IOException {
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

    private static void printMatrixPerLine(Integer[][] array) {
        PrintWriter output = new PrintWriter(System.out);
        for (Integer[] row : array) {
            for (int i = 0; i < row.length; i++) {
                output.print(row[i]);
                if (i + 1 != row.length) {
                    output.print(DELIMITER);
                }
            }
            output.println();
        }
        output.flush();
        output.close();
    }

    private static class Node {
        Integer value;
        List<Distance> siblings;
    }

    private static class Distance {

        Node node;
        int distance;

        public Distance(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }

    }

    private static class ResultSet {
        Node from;

        boolean[] visited;
        Integer[] distance;
        Node[] parent;

        public ResultSet(Node from, int size) {
            this.from = from;

            this.visited = new boolean[size];
            Arrays.fill(this.visited, false);

            this.distance = new Integer[size];
            Arrays.fill(this.distance, NOT_VISITED);

            this.parent = new Node[size];
        }

    }

}