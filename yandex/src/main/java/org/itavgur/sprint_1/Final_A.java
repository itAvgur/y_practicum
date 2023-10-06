package org.itavgur.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 5 окт 2023, 14:47:43
 * 92098620
 */
public class Final_A {

    public static Integer[] process(int __, Integer[] map) {

        int counter = -1;
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0 && counter == -1) {
                map[i] = Integer.MAX_VALUE;
            } else if (map[i] == 0) {
                counter = 0;
                map[i] = 0;
            } else {
                ++counter;
                map[i] = counter;
            }
        }

        counter = -1;
        for (int i = map.length - 1; i >= 0; i--) {
            if (map[i] != 0 && counter == -1) continue;
            if (map[i] == 0) {
                counter = 0;
            } else if (map[i] > counter) {
                ++counter;
                map[i] = counter;
            } else {
                ++counter;
            }
        }

        return map;

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer streetLength = readInt(reader);
            Integer[] map = readIntegers(reader);
            Integer[] result = process(streetLength, map);
            printArray(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
    }

    private static void printArray(Integer[] integers) {
        StringJoiner res = new StringJoiner(" ");
        for (Integer integer : integers) {
            res.add(integer.toString());
        }
        System.out.println(res);
    }

}

/*


    int counter = -1;
        for (int i = 0; i < map.length; i++) {
        if (map[i] != 0 && counter == -1) {
        result[i] = Integer.MAX_VALUE;
        } else if (map[i] == 0 && counter == -1) {
        result[i] = 0;
        int reverseCounter = 1;
        for (int k = i - 1; k >= 0; k--) {
        result[k] = reverseCounter;
        ++reverseCounter;
        }
        counter = 0;
        } else if (map[i] == 0) {
        result[i] = 0;
        int reverseCounter = 1;
        for (int k = i; k > i - (counter / 2); k--) {
        result[k - 1] = reverseCounter;
        ++reverseCounter;
        }
        counter = 0;
        } else {
        ++counter;
        result[i] = counter;
        }
        }


        */