package org.itavgur.sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_D {

    public static String[] process(Integer count, String[] arr) {

        List<String> results = new ArrayList<>();

        Arrays.stream(arr).forEach(name -> {

            boolean notFound = true;
            for (String result : results) {
                if (name.equals(result)) {
                    //has notFound
                    notFound = false;
                    break;
                }
            }
            if (notFound) {
                results.add(name);
            }

        });

        return results.toArray(String[]::new);

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer count = readInt(reader);
            String[] result = process(count, readStrings(reader, count));
            printArrayPerLine(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static String[] readStrings(BufferedReader reader, int count) throws IOException {
        String[] res = new String[count];
        for (int i = 0; i < count; ++i) {
            res[i] = reader.readLine();
        }
        return res;
    }

    private static void printArrayPerLine(String[] strings) {
        PrintWriter output = new PrintWriter(System.out);
        for (String string : strings) {
            output.println(string);
        }
        output.flush();
        output.close();
    }

}