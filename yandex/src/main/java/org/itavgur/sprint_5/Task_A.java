package org.itavgur.sprint_5;

public class Task_A {
    public static int treeSolution(Node head) {

        return findRecursive(head);
    }

    private static int findRecursive(Node node) {

        if (node.left == null && node.right == null) {
            return node.value;
        }

        int left = 0;
        int right = 0;

        if (node.left != null) left = findRecursive(node.left);
        if (node.right != null) right = findRecursive(node.right);

        return Math.max(node.value, Math.max(left, right));
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
    }
}