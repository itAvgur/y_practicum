package org.itavgur.sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Task_H {

    public static String process(String str1, String str2) {

        HashMap<Character, Character> map = new HashMap<>();

        if (str1.length() != str2.length()) {
            return "NO";
        }

        boolean hasDifference = false;
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {

            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (map.containsKey(c1)) {
                if (c2 != map.get(c1)) {
                    hasDifference = true;
                    break;
                }
            } else if (map.containsValue((c2))) {
                hasDifference = true;
                break;
            } else {
                map.put(c1, c2);
            }
        }

        return hasDifference ? "NO" : "YES";
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String result = process(readString(reader), readString(reader));
            System.out.println(result);
        }
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }


}