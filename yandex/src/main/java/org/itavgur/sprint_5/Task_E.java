package org.itavgur.sprint_5;

import java.util.List;

public class Task_E {

    public static boolean treeSolution(Node head) {

        return treeSolutionRecursive(head, null);
    }

    private static boolean treeSolutionRecursive(Node head, Integer previousNodeValue) {
        if (head == null) return true;

        if (head.right != null) {
            if (head.right.value <= head.value) return false;

            if (previousNodeValue != null
                    && previousNodeValue > head.value
                    && head.right.value >= previousNodeValue) return false;
        }

        if (head.left != null) {
            if (head.left.value >= head.value) return false;

            if (previousNodeValue != null
                    && previousNodeValue < head.value
                    && head.left.value <= previousNodeValue) return false;
        }

        return treeSolutionRecursive(head.right, head.value) && treeSolutionRecursive(head.left, head.value);
    }

    protected static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}