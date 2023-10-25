package org.itavgur.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task_B {

    private static final String DELIMITER = " ";
    private static Map<Character, String> keysMap;

    private static void initMap() {

        keysMap = new HashMap<>();
        keysMap.put('2', "abc");
        keysMap.put('3', "def");
        keysMap.put('4', "ghi");
        keysMap.put('5', "jkl");
        keysMap.put('6', "mno");
        keysMap.put('7', "pqrs");
        keysMap.put('8', "tuv");
        keysMap.put('9', "wxyz");
    }

    private static List<String> processRecursive(String inputString) {

        if (inputString.isEmpty()) {
            List<String> emptyList = new ArrayList<>();
            emptyList.add("");
            return emptyList;
        }

        List<String> data = new ArrayList<>();
        String word = keysMap.get(inputString.charAt(inputString.length() - 1));
        List<String> combinations = processRecursive(inputString.substring(0, inputString.length() - 1));
        for (String combination : combinations) {
            for (char ch : word.toCharArray()) {
                data.add(combination + ch);
            }
        }

        return data;
    }

    public static String[] process(String number) {

        initMap();
        return processRecursive(number).toArray(String[]::new);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] result = process(readString(reader));
            printArray(result);
        }
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    private static void printArray(String[] values) {
        PrintWriter output = new PrintWriter(System.out);
        for (String value : values) {
            output.print(value);
            output.print(DELIMITER);
        }
        output.flush();
        output.close();
    }

}