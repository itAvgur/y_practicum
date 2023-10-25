package org.itavgur.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Task_I {

    private static final String DELIMITER = " ";

    public static Integer[] process(Integer number, Integer[] ids, Integer limit) {

        Map<Integer, Integer> map = new TreeMap<>();
        Arrays.stream(ids).forEach(id -> map.merge(id, 1, (value1, value2) -> ++value1));

        List<Integer[]> counts = new ArrayList<>();
        map.forEach((key, value) -> counts.add(new Integer[]{value, key}));

        counts.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });

        Integer[] result = new Integer[Math.min(limit, counts.size())];
        for (int i = 0; i < Math.min(limit, counts.size()); i++) {
            result[i] = counts.get(i)[1];
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Integer rows = readInt(reader);
            Integer[] data = readIntegers(reader);
            Integer limit = readInt(reader);
            Integer[] result = process(rows, data, limit);
            printArrayInLine(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    private static void printArrayInLine(Integer[] integers) {
        PrintWriter output = new PrintWriter(System.out);
        for (Integer integer : integers) {
            output.print(integer);
            output.print(DELIMITER);
        }
        output.flush();
        output.close();
    }
}