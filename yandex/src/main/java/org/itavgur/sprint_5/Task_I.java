package org.itavgur.sprint_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Task_I {

    private static final Map<Integer, Integer> map = new HashMap<>();

    public static Integer process(Integer number) {

        map.put(0, 1);

        if (map.containsKey(number)) {
            return map.get(number);
        } else {
            return calculateRecursively(number, map);
        }

    }

    public static int calculateRecursively(int number, Map<Integer, Integer> map) {

        int res = 0;

        for (int i = 1; i <= number; i++) {

            int left;

            if (map.containsKey(i - 1)) {
                left = map.get(i - 1);
            } else {
                left = calculateRecursively(i - 1, map);
            }

            int right;
            if (map.containsKey(number - i)) {
                right = map.get(number - i);
            } else {
                right = calculateRecursively(number - i, map);
            }

            res = res + left * right;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int number = readInt(reader);
            int result = process(number);
            System.out.println(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}