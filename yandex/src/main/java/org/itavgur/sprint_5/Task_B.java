package org.itavgur.sprint_5;

import java.util.Optional;

public class Task_B {

    private static Optional<Boolean> flag;

    public static boolean treeSolution(Node head) {

        flag = Optional.of(true);

        goDeep(head);

        return flag.get();
    }

    private static int goDeep(Node node) {

        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            return 0;
        }

        int hightLeft = 0;
        int hightRight = 0;

        if (node.left != null) {
            hightLeft = goDeep(node.left) + 1;
        }

        if (node.right != null) {
            hightRight = goDeep(node.right) + 1;
        }

        if (Math.abs(hightLeft - hightRight) > 1) flag = Optional.of(false);

        return Math.max(hightLeft, hightRight);

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
    }
    // <template>

}