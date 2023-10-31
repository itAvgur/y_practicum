package org.itavgur.sprint_4;

import org.itavgur.LinkedList.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Final_BTest {

    @Test
    public void test() {
        String[] result;
        String[] input;
        String[] expected;

        input = new String[]{"get 1", "put 1 10", "put 2 4", "get 1", "get 2", "delete 2",
                "get 2", "put 1 5", "get 1", "delete 2"};
        expected = new String[]{"None", "10", "4", "4", "None", "5", "None"};
        result = new FinalB().process(20, input);
        assertArrayEquals(expected, result);


        input = new String[]{"get 9", "delete 9", "put 9 1", "get 9", "put 9 2", "get 9", "put 9 3", "get 9"};
        expected = new String[]{"None", "None", "1", "2", "3"};
        result = new FinalB().process(10, input);
        assertArrayEquals(expected, result);

    }

    @Test
    public void testFailed() {
        String[] result;
        String[] input;
        String[] expected;

        input = new String[]{"put 20 27", "get 20", "put 20 21", "get 20", "get 20", "get -1", "get 20", "get -3", "delete 20"
                , "get -29", "get -33", "delete -29", "get 16", "get 14", "put 29 39"};
        expected = new String[]{"27", "21", "21", "None", "21", "None", "21", "None", "None", "None", "None", "None"};
        result = new FinalB().process(100, input);
        assertArrayEquals(expected, result);

    }

    @Test
    public void testTL() {
        String[] result;
        String[] input;
        String[] expected;


        input = new String[]{"put -470 403", "get -470"};
        expected = new String[]{"403"};
        result = new FinalB().process(3, input);
        assertArrayEquals(expected, result);

        input = new String[]{"get 9", "get 37", "get 30", "get -18", "get -5", "put 15 23", "delete 15", "get 7", "put 3 18"
                , "get 3", "put 19 -17", "get -12", "get 19", "get -39", "get 39"};
        expected = new String[]{"None", "None", "None", "None", "None", "23", "None", "18", "None", "-17", "None", "None"};
        result = new FinalB().process(100, input);
        assertArrayEquals(expected, result);

    }

    @Test
    public void testNode() {

        Node<Integer> n0 = Node.init(0);
        Node<Integer> n1 = n0.next(1);
        Node<Integer> n2 = n1.next(2);
        Node<Integer> n3 = n2.next(3);
        Assertions.assertEquals(4, n3.array().length);

    }


}