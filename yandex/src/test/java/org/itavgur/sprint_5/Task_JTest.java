package org.itavgur.sprint_5;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class Task_JTest extends Task_J {

    @Test
    public void test() throws IOException {
        Node node1 = new Node(null, null, 7);
        Node node2 = new Node(node1, null, 8);
        Node node3 = new Node(null, node2, 7);
        Node newHead = insert(node3, 6);
        assert newHead == node3;
        assert newHead.getLeft().getValue() == 6;
    }

    @Test
    public void testFailed() throws IOException {
        Node node3 = new Node(null, null, 7);
        Node node2 = new Node(node3, null, 9);
        Node node1 = new Node(null, node2, 7);
        Node newHead = insert(node1, 7);
    }

}