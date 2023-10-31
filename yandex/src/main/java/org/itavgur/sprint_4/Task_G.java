package org.itavgur.sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Task_G {

    private static final String DELIMITER = " ";

    public static Integer process(Integer count, Integer[] arr) {

        if (arr.length < 2) return 0;

        AtomicInteger maxValue = new AtomicInteger();

        int[] ints = new int[arr.length + 1];
        ints[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            ints[i + 1] = ints[i] + (arr[i] == 0 ? 1 : -1);
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int idx = 0; idx < ints.length; idx++) {
            int value = ints[idx];
            if (map.containsKey(value)) {
                map.get(value).add(idx);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(idx);
                map.put(value, newList);
            }
        }

        map.values().forEach(list -> {
            maxValue.set(Math.abs(Math.max(list.get(list.size() - 1) - list.get(0), maxValue.get())));
        });

        return maxValue.get();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer count = readInt(reader);
            System.out.println((process(count, readIntegers(reader))));
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {

        return Arrays.stream(reader.readLine().split(DELIMITER))
                .filter(str -> !str.isBlank())
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

}