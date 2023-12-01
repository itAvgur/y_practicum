package org.itavgur.sprint_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task_CTest extends Task_C {

    @Test
    public void test1() {
        Node node6 = new Node(3, null, null);
        Node node5 = new Node(4, null, null);
        Node node4 = new Node(4, null, null);
        Node node3 = new Node(3, null, null);
        Node node2 = new Node(2, node5, node6);
        Node node1 = new Node(2, node3, node4);
        Node node0 = new Node(1, node1, node2);

        Assertions.assertTrue(treeSolution(node0));
    }

    @Test
    public void test8() {
        Node node8 = new Node(1, null, null);
        Node node7 = new Node(1, null, null);
        Node node6 = new Node(1, null, null);
        Node node5 = new Node(0, null, null);
        Node node4 = new Node(3, node7, node8);
        Node node3 = new Node(3, node5, node6);
        Node node2 = new Node(2, null, node4);
        Node node1 = new Node(2, node3, null);
        Node node0 = new Node(0, node1, node2);

        Assertions.assertFalse(treeSolution(node0));
    }

    @Test
    public void test7() {
        Node node8 = new Node(0, null, null);
        Node node7 = new Node(1, null, null);
        Node node6 = new Node(1, null, null);
        Node node5 = new Node(0, null, null);
        Node node4 = new Node(3, node7, node8);
        Node node3 = new Node(3, node5, node6);
        Node node2 = new Node(2, null, node4);
        Node node1 = new Node(2, node3, null);
        Node node0 = new Node(0, node1, node2);

        Assertions.assertTrue(treeSolution(node0));
    }

    @Test
    public void test5() {
        Node node3 = new Node(3, null, null);
        Node node2 = new Node(3, null, null);
        Node node1 = new Node(2, node2, node3);
        Node node0 = new Node(1, null, node1);

        Assertions.assertFalse(treeSolution(node0));
    }

    @Test
    public void test2() {
        Node node0 = new Node(1, null, null);

        Assertions.assertTrue(treeSolution(node0));
    }

}