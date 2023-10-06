package org.itavgur.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task_L {

    public static String process(String[] ar) {

        StringBuilder sb = new StringBuilder();
        Arrays.stream(ar).forEach(sb::append);
        char[] fullString = sb.toString().toCharArray();
        Arrays.sort(fullString);

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < fullString.length; i++) {
            char key = fullString[i];
            if (map.containsKey(key)) {
                map.compute(key, (_none, counter) -> counter + 1);
            } else {
                map.put(key, 1);
            }
        }

        return map.entrySet().stream().filter(val -> val.getValue() % ar.length != 0).findFirst().get().getKey().toString();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] input = {readString(reader), readString(reader)};
            String result = process(input);
            System.out.println(result);
        }
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

}