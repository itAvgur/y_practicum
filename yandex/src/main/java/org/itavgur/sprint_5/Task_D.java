package org.itavgur.sprint_5;

import java.util.ArrayList;
import java.util.List;

public class Task_D {
    public static boolean treeSolution(Node head1, Node head2) {

        return compareLists(
                parseTree(head1, new ArrayList<>(), 0),
                parseTree(head2, new ArrayList<>(), 0)
        );
    }

    private static List<Integer[]> parseTree(Node head, List<Integer[]> list, Integer idx) {

        if (idx == 0) {
            list.add(new Integer[]{1, head.value});
            idx = 1;
        }

        if (head.left != null) {
            list.add(new Integer[]{idx * 2, head.left.value});
            parseTree(head.left, list, idx * 2);
        }

        if (head.right != null) {
            list.add(new Integer[]{idx * 2 + 1, head.right.value});
            parseTree(head.right, list, idx * 2 + 1);
        }

        return list;
    }

    private static boolean compareLists(List<Integer[]> list1, List<Integer[]> list2) {

        if (list1.size() != list2.size()) return false;

        for (int i = 0; i < list1.size(); i++) {
            Integer[] ints1 = list1.get(i);
            Integer[] ints2 = list2.get(i);
            if (ints1[0] != ints2[0]
                    || ints1[1] != ints2[1])
                return false;
        }

        return true;
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