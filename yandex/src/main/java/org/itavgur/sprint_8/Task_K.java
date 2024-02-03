package org.itavgur.sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_K {

    protected static final String DELIMITER = " ";

    protected static int compareTwoString(String str1, String str2) {

        StringBuilder sb1 = new StringBuilder();
        str1.chars()
                .filter(value -> value % 2 == 0)
                .mapToObj(value -> (char) value)
                .forEach(sb1::append);


        StringBuilder sb2 = new StringBuilder();
        str2.chars()
                .filter(value -> value % 2 == 0)
                .mapToObj(value -> (char) value)
                .forEach(sb2::append);

        int compareResult = sb1.toString().compareTo(sb2.toString());

        return Integer.compare(compareResult, 0);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String passportName = readString(reader);
            String dbName = readString(reader);
            System.out.println(compareTwoString(passportName, dbName));
        }
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

}