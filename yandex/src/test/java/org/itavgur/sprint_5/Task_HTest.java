package org.itavgur.sprint_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task_HTest extends Task_H {

    @Test
    public void test() {

        Node node5 = new Node(1, null, null);
        Node node4 = new Node(2, null, null);
        Node node3 = new Node(3, node4, node5);
        Node node2 = new Node(2, null, null);
        Node node1 = new Node(1, node2, node3);

        Assertions.assertEquals(275, treeSolution(node1));
    }

    @Test
    public void test6() {

        Node node9 = new Node(9, null, null);
        Node node8 = new Node(8, node9, null);
        Node node7 = new Node(7, null, null);
        Node node6 = new Node(6, null, null);
        Node node5 = new Node(2, null, null);
        Node node4 = new Node(4, node7, node8);
        Node node3 = new Node(3, node5, node6);
        Node node2 = new Node(2, null, node4);
        Node node1 = new Node(1, node3, null);
        Node node0 = new Node(1, node1, node2);

        Assertions.assertEquals(16004, treeSolution(node0));
    }

}