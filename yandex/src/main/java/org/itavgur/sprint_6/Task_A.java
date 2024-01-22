package org.itavgur.sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_A {

    private static final String DELIMITER = " ";

    protected static NodeInfo[] process(Integer[][] links, Integer[] briefInfo) {

        NodeInfo[] res = new NodeInfo[briefInfo[0]];

        for (int i = 0; i < links.length; i++) {
            Integer[] link = links[i];

            if (res[link[0] - 1] == null) {
                List<Integer> destNodes = new ArrayList<>();
                destNodes.add(link[1]);
                res[link[0] - 1] = new NodeInfo(destNodes);
            } else {
                res[link[0] - 1].destNodes.add(link[1]);
            }

        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] == null) {
                res[i] = new NodeInfo(List.of(0));
            } else {
                res[i].destNodes.add(0, res[i].destNodes.size());
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] briefInfo = readIntegers(reader);
            Integer[][] links = readMatrix(reader, briefInfo[1], 2);

            NodeInfo[] result = process(links, briefInfo);
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

    private static void printMatrixPerLine(NodeInfo[] array) {
        PrintWriter output = new PrintWriter(System.out);
        for (NodeInfo node : array) {
            for (int i = 0; i < node.destNodes.size(); i++) {
                output.print(node.destNodes.get(i));
                if (i + 1 != node.destNodes.size()) {
                    output.print(DELIMITER);
                }
            }
            output.println();
        }
        output.flush();
        output.close();
    }

    protected static class NodeInfo {
        List<Integer> destNodes;

        public NodeInfo(List<Integer> destNodes) {
            this.destNodes = destNodes;
        }

        @Override
        public boolean equals(Object obj) {

            if (obj instanceof NodeInfo) {
                return this.destNodes.equals(((NodeInfo) obj).destNodes);
            }
            return false;
        }
    }

}