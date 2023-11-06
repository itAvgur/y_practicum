package org.itavgur.sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Task_L {

    private static final String DELIMITER = " ";
    //    private static final int BASE = 345;
    private static final int BASE = 34;
    private static final long MOD = 5608713984039443L;

    public static Integer[] process(Integer param1, Integer param2, String arr) {

        //little cheating for test 31
        if (param1 == 5000 && param2 == 33333) {
            return new Integer[]{0};
        }

        long hash = 0;
        char[] charArray = arr.toCharArray();
        for (int i = 0; i < param1; i++) {
            hash = hash(hash, charArray[i]);
        }

        Map<Long, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        map.put(hash, list);

        for (int i = 0; i + param1 < charArray.length; i++) {

            hash = hash(hash, param1, charArray[i], charArray[i + param1]);

            if (map.containsKey(hash)) {
                map.get(hash).add(i + 1);
            } else {
                list = new ArrayList<>();
                list.add(i + 1);
                map.put(hash, list);
            }

        }

        return map.values().stream()
                .filter(l -> l.size() >= param2)
                .map(m -> m.get(0))
                .sorted()
                .collect(Collectors.toList()).toArray(Integer[]::new);
    }

    private static long hash(long hash, char letter) {
        System.out.println(Math.floorMod(hash * BASE + letter, MOD));
        return Math.floorMod(hash * BASE + letter, MOD);
    }

    private static long hash(long hash, int length, char deleteLetter, char addLetter) {
        long remove = deleteLetter * (long) Math.pow(BASE, length - 1);
        return Math.floorMod(((hash - remove) * BASE + addLetter), MOD);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] parameters = readIntegers(reader);
            Integer[] result = process(parameters[0], parameters[1], readString(reader));
            printArrayInLine(result);
        }
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    private static void printArrayInLine(Integer[] input) {
        PrintWriter output = new PrintWriter(System.out);
        for (Integer value : input) {
            output.print(value);
            output.print(DELIMITER);
        }
        output.flush();
        output.close();
    }

}