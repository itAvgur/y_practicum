package org.itavgur.sprint_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task_ETest extends Task_E {

    @Test
    public void test() {
        Node node1 = new Task_E.Node(1, null, null);
        Node node2 = new Task_E.Node(4, null, null);
        Node node3 = new Task_E.Node(3, node1, node2);
        Node node4 = new Task_E.Node(8, null, null);
        Node node5 = new Task_E.Node(5, node3, node4);
        assert treeSolution(node5);
        node2.value = 5;
        assert !treeSolution(node5);
    }

    @Test
    public void testSuccess() {
        Node node6 = new Task_E.Node(7, null, null);
        Node node5 = new Task_E.Node(6, null, null);
        Node node4 = new Task_E.Node(4, null, null);
        Node node3 = new Task_E.Node(1, null, null);
        Node node2 = new Task_E.Node(8, node5, node6);
        Node node1 = new Task_E.Node(3, node3, node4);
        Node node0 = new Task_E.Node(5, node1, node2);

        Assertions.assertFalse(treeSolution(node0));
        assert treeSolution(node5);
    }


}