package org.itavgur.sprint_5;

import org.junit.jupiter.api.Test;

class Task_ATest extends Task_A {

    @Test
    public void test() {
        Task_A.Node node1 = new Task_A.Node(1);
        Task_A.Node node2 = new Task_A.Node(-5);
        Task_A.Node node3 = new Task_A.Node(3);
        node3.left = node1;
        node3.right = node2;
        Task_A.Node node4 = new Task_A.Node(2);
        node4.left = node3;
        assert treeSolution(node4) == 3;
    }

}