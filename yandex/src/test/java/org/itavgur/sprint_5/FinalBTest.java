package org.itavgur.sprint_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.itavgur.sprint_5.FinalB.remove;

class FinalBTest extends Task_K {

    @Test
    public void test() throws IOException {

        FinalB.Node node2 = new FinalB.Node(null, null, 2);
        FinalB.Node node3 = new FinalB.Node(node2, null, 3);
        FinalB.Node node1 = new FinalB.Node(null, node3, 1);
        FinalB.Node node6 = new FinalB.Node(null, null, 6);
        FinalB.Node node8 = new FinalB.Node(node6, null, 8);
        FinalB.Node node10 = new FinalB.Node(node8, null, 10);
        FinalB.Node node5 = new FinalB.Node(node1, node10, 5);
        FinalB.Node newHead = remove(node5, 10);
        Assertions.assertEquals(node5, newHead);
        Assertions.assertEquals(node8, newHead.getRight());
        Assertions.assertEquals(node5, newHead);
    }

    @Test
    public void testRemoveRoot() {

        FinalB.Node node2 = new FinalB.Node(null, null, 2);
        FinalB.Node node3 = new FinalB.Node(node2, null, 3);
        FinalB.Node node1 = new FinalB.Node(null, node3, 1);
        FinalB.Node node6 = new FinalB.Node(null, null, 6);
        FinalB.Node node8 = new FinalB.Node(node6, null, 8);
        FinalB.Node node10 = new FinalB.Node(node8, null, 10);
        FinalB.Node node5 = new FinalB.Node(node1, node10, 5);
        FinalB.Node newHead = remove(node5, 5);
        Assertions.assertEquals(node3, newHead);
        Assertions.assertEquals(node1, newHead.getLeft());
        Assertions.assertEquals(node2, newHead.getLeft().getRight());
    }

    @Test
    public void testRemoveLeft() {

        FinalB.Node node13 = new FinalB.Node(null, null, 13);
        FinalB.Node node11 = new FinalB.Node(null, null, 11);
        FinalB.Node node2 = new FinalB.Node(null, null, 2);
        FinalB.Node node4 = new FinalB.Node(node2, null, 4);
        FinalB.Node node1 = new FinalB.Node(null, null, 1);
        FinalB.Node node18 = new FinalB.Node(null, null, 18);
        FinalB.Node node12 = new FinalB.Node(node11, node13, 12);
        FinalB.Node node8 = new FinalB.Node(null, null, 8);
        FinalB.Node node3 = new FinalB.Node(node1, node4, 3);
        FinalB.Node node15 = new FinalB.Node(node12, node18, 15);
        FinalB.Node node5 = new FinalB.Node(node3, node8, 5);
        FinalB.Node node10 = new FinalB.Node(node5, node15, 10);
        FinalB.Node newHead = remove(node10, 5);

        Assertions.assertEquals(10, newHead.getValue());
        Assertions.assertEquals(node4, newHead.getLeft());
        Assertions.assertEquals(node8, newHead.getLeft().getRight());
        Assertions.assertEquals(node3, newHead.getLeft().getLeft());
        Assertions.assertEquals(node1, newHead.getLeft().getLeft().getLeft());
        Assertions.assertEquals(node2, newHead.getLeft().getLeft().getRight());
    }

    @Test
    public void test2() {

        FinalB.Node node13 = new FinalB.Node(null, null, 13);
        FinalB.Node node11 = new FinalB.Node(null, null, 11);
        FinalB.Node node2 = new FinalB.Node(null, null, 2);
        FinalB.Node node4 = new FinalB.Node(node2, null, 4);
        FinalB.Node node1 = new FinalB.Node(null, null, 1);
        FinalB.Node node18 = new FinalB.Node(null, null, 18);
        FinalB.Node node12 = new FinalB.Node(node11, node13, 12);
        FinalB.Node node8 = new FinalB.Node(null, null, 8);
        FinalB.Node node3 = new FinalB.Node(node1, node4, 3);
        FinalB.Node node15 = new FinalB.Node(node12, node18, 15);
        FinalB.Node node5 = new FinalB.Node(node3, node8, 5);
        FinalB.Node node10 = new FinalB.Node(node5, node15, 10);
        FinalB.Node newHead = remove(node10, 15);

        Assertions.assertEquals(10, newHead.getValue());
        Assertions.assertEquals(node13, newHead.getRight());
        Assertions.assertEquals(node18, newHead.getRight().getRight());
        Assertions.assertEquals(node12, newHead.getRight().getLeft());
        Assertions.assertEquals(node11, newHead.getRight().getLeft().getLeft());
        Assertions.assertEquals(null, newHead.getRight().getLeft().getRight());
    }

    @Test
    public void testFailed() {

        FinalB.Node node7 = new FinalB.Node(null, null, 7);
        FinalB.Node node5 = new FinalB.Node(null, null, 5);
        FinalB.Node node3 = new FinalB.Node(null, null, 3);
        FinalB.Node node1 = new FinalB.Node(null, null, 1);
        FinalB.Node node6 = new FinalB.Node(node5, node7, 6);
        FinalB.Node node2 = new FinalB.Node(node1, node3, 2);
        FinalB.Node node4 = new FinalB.Node(node2, node6, 4);
        FinalB.Node newHead = remove(node4, 7);
        Assertions.assertEquals(node4, newHead);
        Assertions.assertEquals(node6, newHead.getRight());
        Assertions.assertEquals(node5, newHead.getRight().getLeft());
        Assertions.assertEquals(null, newHead.getRight().getRight());
    }

    @Test
    public void testFailed2() {

        FinalB.Node node15 = new FinalB.Node(null, null, 15);
        FinalB.Node node20 = new FinalB.Node(node15, null, 20);
        FinalB.Node node10 = new FinalB.Node(null, node20, 10);
        FinalB.Node newHead = remove(node10, 10);
        Assertions.assertEquals(node15, newHead);
        Assertions.assertEquals(node20, newHead.getRight());
    }

    @Test
    public void testFailedDeleteWholeTree() {
        FinalB.Node node3 = new FinalB.Node(null, null, 3);
        FinalB.Node node2 = new FinalB.Node(null, null, 2);
        FinalB.Node node1 = new FinalB.Node(node2, node3, 1);
        FinalB.Node remove1 = remove(node1, 1);
        Assertions.assertEquals(node2, remove1);
        FinalB.Node remove2 = remove(remove1, 2);
        Assertions.assertEquals(node3, remove2);
        FinalB.Node remove3 = remove(remove2, 3);
        Assertions.assertNull(remove3);
    }

    @Test
    public void testFailedDeleteWholeTree3() {
        FinalB.Node node4 = new FinalB.Node(null, null, 1);
        FinalB.Node node3 = new FinalB.Node(node4, null, 4);
        FinalB.Node node2 = new FinalB.Node(null, node3, 3);
        FinalB.Node node1 = new FinalB.Node(node2, null, 5);
        FinalB.Node remove1 = remove(node1, 5);
        FinalB.Node remove2 = remove(remove1, 3);
        FinalB.Node remove3 = remove(remove2, 1);
        FinalB.Node removeAll = remove(remove3, 4);
        Assertions.assertNull(removeAll);
    }

}