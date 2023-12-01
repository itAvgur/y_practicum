package org.itavgur.sprint_5;

public class Task_F {
    public static int treeSolution(Node head) {

        if (head == null) return 0;

        return Math.max(treeSolution(head.left), treeSolution(head.right)) + 1;
    }

    // <template>
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
    // <template>
}