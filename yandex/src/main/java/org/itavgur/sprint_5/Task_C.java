package org.itavgur.sprint_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Task_C {

    public static boolean treeSolution(Node head) {

        Map<Integer, Node> nodes = makeArray(new HashMap<>(), head, 1);
        nodes.put(1, head);

        if (nodes.size() == 1) return true;
        if (nodes.get(2) == null || nodes.get(3) == null || nodes.get(2).value != nodes.get(3).value) return false;

        return checkEquals(nodes, 4, 6);
    }

    private static boolean checkEquals(Map<Integer, Node> nodes, int idxLeft, int idxRight) {

        Integer left = nodes.containsKey(idxLeft) ? nodes.get(idxLeft).value : null;
        Integer right = nodes.containsKey(idxLeft + 1) ? nodes.get(idxRight).value : null;
        Integer leftSibling = nodes.containsKey(idxRight) ? nodes.get(idxRight).value : null;
        Integer rightSibling = nodes.containsKey(idxRight + 1) ? nodes.get(idxRight + 1).value : null;

        if (left == null && right == null && leftSibling == null && rightSibling == null) return true;

        if (Objects.equals(left, right) && Objects.equals(left, leftSibling) && Objects.equals(right, rightSibling)) {
            // layer equal

            return checkEquals(nodes, idxLeft * 2, idxRight * 2) && checkEquals(nodes, idxLeft * 2 + 1, idxRight * 2 + 1);

        } else if (Objects.equals(left, rightSibling) && Objects.equals(right, leftSibling)) {
            // layer symmetric
            return checkEquals(nodes, idxLeft * 2, idxRight * 2 + 2) && checkEquals(nodes, idxLeft * 2 + 2, idxRight * 2);
        }
        return false;

    }

    private static Map<Integer, Node> makeArray(Map<Integer, Node> nodes, Node head, int idx) {

        if (head.left != null) {
            nodes.put(idx * 2, head.left);
            makeArray(nodes, head.left, idx * 2);
        }

        if (head.right != null) {
            nodes.put(idx * 2 + 1, head.right);
            makeArray(nodes, head.right, idx * 2 + 1);
        }

        return nodes;
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

}