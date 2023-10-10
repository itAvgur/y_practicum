package org.itavgur.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 5 окт 2023, 14:09:31
 * 92095638
 */
public class Final_B {

    private static final Integer KEYBOARD_ROWS_SIZE = 4;
    private static final Integer KEYBOARD_COLUMNS_SIZE = 4;

    public static Integer process(int maxClick, String[][] map) {

        Map<Integer, Integer> keysMap = new HashMap<>();
        for (String[] strings : map) {
            for (String button : strings) {
                if (".".equals(button)) continue;
                int intValue = Integer.parseInt(button);
                keysMap.merge(intValue, 1, Integer::sum);
            }
        }

        return (int) keysMap.entrySet().stream()
                .filter(entry -> entry.getValue() <= maxClick * 2)
                .count();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int maxClick = readInt(reader);
            String[][] map = readMatrix(reader, KEYBOARD_ROWS_SIZE, KEYBOARD_COLUMNS_SIZE);
            Integer result = process(maxClick, map);
            System.out.println(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static String[] readStrings(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(Pattern.quote(""))).toArray(String[]::new);
    }

    protected static String[][] readMatrix(BufferedReader reader, int rows, int columns) throws IOException {
        String[][] res = new String[rows][columns];
        for (int i = 0; i < rows; ++i) {
            String[] strings = readStrings(reader);
            res[i] = strings;
        }
        return res;
    }

}