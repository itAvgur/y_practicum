package org.itavgur;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HashTableTest {

    private static final String DELIMITER = " ";
    private static final String PUT_CMD = "put";
    private static final String GET_CMD = "get";
    private static final String DELETE_CMD = "delete";
    private static final String ELEMENT_NOT_FOUND = "None";

    private static String[] process(String[] commands) {

        HashTable<Integer, Integer> hashTable = new HashTable<>();
        List<String> output = new ArrayList<>();

        for (String command : commands) {
            String[] parsedCommand = command.split(DELIMITER);
            if (PUT_CMD.equals(parsedCommand[0])) {
                hashTable.put(Integer.parseInt(parsedCommand[1]), Integer.parseInt(parsedCommand[2]));
            } else if (GET_CMD.equals(parsedCommand[0])) {
                Integer value = hashTable.get(Integer.parseInt(parsedCommand[1]));
                output.add(value == null ? ELEMENT_NOT_FOUND : "" + value);
            } else if (DELETE_CMD.equals(parsedCommand[0])) {
                Integer deletedValue = hashTable.delete(Integer.parseInt(parsedCommand[1]));
                output.add(deletedValue == null ? ELEMENT_NOT_FOUND : "" + deletedValue);
            } else {
                throw new RuntimeException("Unknown command");
            }
        }
        return output.toArray(String[]::new);
    }

    @Test
    public void test() {
        String[] result;
        String[] input;
        String[] expected;

        input = new String[]{"get 1", "put 1 10", "put 2 4", "get 1", "get 2", "delete 2",
                "get 2", "put 1 5", "get 1", "delete 2"};
        expected = new String[]{"None", "10", "4", "4", "None", "5", "None"};
        result = process(input);
        assertArrayEquals(expected, result);


        input = new String[]{"get 9", "delete 9", "put 9 1", "get 9", "put 9 2", "get 9", "put 9 3", "get 9"};
        expected = new String[]{"None", "None", "1", "2", "3"};
        result = process(input);
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
        result = process(input);
        assertArrayEquals(expected, result);

    }

    @Test
    public void testTL() {
        String[] result;
        String[] input;
        String[] expected;

        input = new String[]{"put -470 403", "get -470"};
        expected = new String[]{"403"};
        result = process(input);
        assertArrayEquals(expected, result);

        input = new String[]{"get 9", "get 37", "get 30", "get -18", "get -5", "put 15 23", "delete 15", "get 7", "put 3 18"
                , "get 3", "put 19 -17", "get -12", "get 19", "get -39", "get 39"};
        expected = new String[]{"None", "None", "None", "None", "None", "23", "None", "18", "None", "-17", "None", "None"};
        result = process(input);
        assertArrayEquals(expected, result);

    }

}