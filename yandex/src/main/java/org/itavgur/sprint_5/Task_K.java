package org.itavgur.sprint_5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task_K {
    public static void printRange(Node root, int L, int R, BufferedWriter writer) throws IOException {

        List<Integer> results = new ArrayList<>();
        find(root, L, R, results);

        results.stream().sorted().forEach(v -> {
                    try {
                        writer.write(" " + v +"\n");
                    } catch (IOException e) {
                        //nothing
                    }
                }
        );
    }

    private static Node find(Node node, int L, int R, List<Integer> res) {
        Node sibling = null;
        Node self = null;

        if (node.left != null && L <= node.value) {
            //left
            sibling = find(node.left, L, R, res);
        }
        if (node.right != null) {
            //right
            sibling = find(node.right, L, R, res);
        }

        if (node.value >= L && node.value <= R) {
            self = node;
            res.add(self.value);
            return sibling == null ? self : sibling;
        }

        return sibling == null ? self : sibling;
    }

    // <template>
    protected static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }
    }
}