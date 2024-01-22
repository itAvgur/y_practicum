package org.itavgur.sprint_6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_ATest {

    @Test
    public void test() {

        Task_A.NodeInfo[] expected;
        Task_A.NodeInfo[] result;

        Integer[] brief = {5, 3};
        Integer[][] links = {{1, 3}, {2, 3}, {5, 2}};
        expected = new Task_A.NodeInfo[]{
                new Task_A.NodeInfo(List.of(1, 3)),
                new Task_A.NodeInfo(List.of(1, 3)),
                new Task_A.NodeInfo(List.of(0)),
                new Task_A.NodeInfo(List.of(0)),
                new Task_A.NodeInfo(List.of(1, 2))
        };
        result = Task_A.process(links, brief);
        assertArrayEquals(expected, result);


    }

}