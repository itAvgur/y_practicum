package org.itavgur.sprint_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task_FTest extends Task_F {

    @Test
    public void test() {
        Node node5 = new Node(1, null, null);
        Node node4 = new Node(4, null, null);
        Node node3 = new Node(8, null, null);
        Node node2 = new Node(3, node5, node4);
        Node node1 = new Node(5, node2, node3);

        Assertions.assertEquals(3, treeSolution(node1));
    }

}