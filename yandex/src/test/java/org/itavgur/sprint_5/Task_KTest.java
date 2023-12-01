package org.itavgur.sprint_5;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

class Task_KTest extends Task_K {

    @Test
    public void test() throws IOException {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(null, node1, 1);
        Node node3 = new Node(null, null, 8);
        Node node4 = new Node(null, node3, 8);
        Node node5 = new Node(node4, null, 9);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node2, node6, 5);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        printRange(node7, 2, 8, writer);
        writer.flush();
        // expected output: 2 5 8 8
    }

    @Test
    public void test1() throws IOException {
        Node node8 = new Node(null, null, 4);
        Node node7 = new Node(null, null, 6);
        Node node6 = new Node(null, node8, 4);
        Node node5 = new Node(node6, node7, 5);
        Node node4 = new Node(null, null, 4);
        Node node3 = new Node(null, null, 1);
        Node node2 = new Node(node3, node4, 3);
        Node node1 = new Node(node2, node5, 4);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        printRange(node1, 3, 5, writer);
        writer.flush();
        // expected output: 3 4 4 4 4 5
    }

    @Test
    public void testFailed() throws IOException {
        Node node5 = new Node(null, null, 15);
        Node node4 = new Node(null, node5, 11);
        Node node3 = new Node(null, null, 1);
        Node node2 = new Node(node3, node3, 3);
        Node node1 = new Node(node2, node4, 7);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        printRange(node1, 6, 14, writer);
        writer.flush();
        // expected output: 7 11
    }

    @Test
    public void testFaile2() throws IOException {
        Node node9 = new Node(null, null, 3);
        Node node8 = new Node(null, node9, 1);
        Node node7 = new Node(node8, null, 1);
        Node node6 = new Node(null, node8, 1);
        Node node5 = new Node(node7, null, 1);
        Node node4 = new Node(node5, node6, 1);
        Node node3 = new Node(node4, null, 1);
        Node node2 = new Node(node3, null, 3);
        Node node1 = new Node(node2, null, 5);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        printRange(node1, 1, 5, writer);
        writer.flush();
        // expected output: 1...
    }

}