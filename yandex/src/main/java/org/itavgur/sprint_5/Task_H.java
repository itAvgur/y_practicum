package org.itavgur.sprint_5;

import java.util.ArrayList;
import java.util.List;

public class Task_H {
    public static int treeSolution(Node head) {

        List<String> res = new ArrayList<>();

        processRecursively(head, res, "");

        return res.stream().map(Integer::parseInt).reduce(Integer::sum).get();

    }

    public static void processRecursively(Node head, List<String> res, String str) {

        if (head.left == null && head.right == null) {
            res.add(str + head.value);
            return;
        }

        if (head.left != null) {
            processRecursively(head.left, res, str + head.value);
        }

        if (head.right != null) {
            processRecursively(head.right, res, str + head.value);
        }

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