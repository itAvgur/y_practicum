package org.itavgur.sprint_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task_BTest extends Task_B {

    @Test
    public void test() {
        Task_B.Node node1 = new Task_B.Node(1);
        Task_B.Node node2 = new Task_B.Node(-5);
        Task_B.Node node3 = new Task_B.Node(3);
        node3.left = node1;
        node3.right = node2;
        Task_B.Node node4 = new Task_B.Node(10);
        Task_B.Node node5 = new Task_B.Node(2);
        node5.left = node3;
        node5.right = node4;
        assert treeSolution(node5);
    }

    @Test
    public void testFailed() {
        Task_B.Node node8 = new Task_B.Node(8);
        Task_B.Node node7 = new Task_B.Node(7);
        Task_B.Node node6 = new Task_B.Node(6);
        Task_B.Node node5 = new Task_B.Node(5);
        Task_B.Node node4 = new Task_B.Node(4);
        Task_B.Node node3 = new Task_B.Node(3);
        Task_B.Node node2 = new Task_B.Node(2);
        Task_B.Node node1 = new Task_B.Node(1);
        Task_B.Node node0 = new Task_B.Node(0);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        Assertions.assertFalse(treeSolution(node0));
    }

    @Test
    public void testRE() {
        Task_B.Node node1 = new Task_B.Node(1);
        Task_B.Node node0 = new Task_B.Node(0);
        node0.right = node1;
        assert treeSolution(node0);
    }

    @Test
    public void testFailed2() {
        Task_B.Node node2 = new Task_B.Node(2);
        Task_B.Node node1 = new Task_B.Node(1);
        Task_B.Node node0 = new Task_B.Node(0);
        node0.right = node1;
        node1.right = node2;
        Assertions.assertFalse(treeSolution(node0));
    }

}