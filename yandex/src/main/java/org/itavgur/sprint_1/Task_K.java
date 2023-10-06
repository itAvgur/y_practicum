package org.itavgur.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Task_K {

    public static Integer[] process(Integer[] first, Integer number) {

        char[] chars = number.toString().toCharArray();
        Integer[] second = new Integer[chars.length];
        for (int i = 0; i < chars.length; i++) {
            second[i] = chars[i] - '0';
        }
        reverseArray(first);
        reverseArray(second);

        int length = Math.max(first.length, second.length);

        List<Integer> res = new ArrayList<>();

        int remain = 0;
        for (int i = 0; i < length; i++) {
            int sum = 0;

            if (i < first.length) sum += first[i];
            if (i < second.length) sum += second[i];

            if (sum + remain > 9) {
                sum = sum + remain - 10;
                remain = 1;
            } else {
                sum = sum + remain;
                remain = 0;
            }
            res.add(sum);
        }
        if (remain == 1) res.add(1);

        Integer[] resArray = res.toArray(Integer[]::new);
        reverseArray(resArray);

        return resArray;
    }

    private static void reverseArray(Integer[] array) {

        for (int i = 0; i < array.length / 2; i++) {
            int value = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = value;
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            readInt(reader);
            Integer[] array = readIntegers(reader);
            Integer number = readInt(reader);
            Integer[] result = process(array, number);
            printArray(result);
        }
    }

    private static void printArray(Integer[] integers) {
        StringJoiner res = new StringJoiner(" ");
        for (Integer integer : integers) {
            res.add(integer.toString());
        }
        System.out.println(res);
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

}