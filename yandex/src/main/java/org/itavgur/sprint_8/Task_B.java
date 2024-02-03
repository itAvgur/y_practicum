package org.itavgur.sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_B {

    protected static final String DELIMITER = " ";
    protected static final String OK_ANSWER = "OK";
    protected static final String FAIL_ANSWER = "FAIL";

    protected static String customsControl(String passportName, String dbName) {

        int changes = 0;
        int maxLength = Math.max(passportName.length(), dbName.length());

        int passportLength = passportName.length();
        int dbNameLength = dbName.length();
        passportName = String.format("%-" + maxLength + "s", passportName);
        dbName = String.format("%-" + maxLength + "s", dbName);

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < maxLength && pointer2 < maxLength) {

            char letter1 = passportName.charAt(pointer1);
            char letter2 = dbName.charAt(pointer2);

            if (letter1 == letter2) {
                ++pointer1;
                ++pointer2;
                continue;
            }

            if (letter2 == passportName.charAt(pointer1 + 1)) {
                ++changes;
                ++pointer1;
            } else if (letter1 == dbName.charAt(pointer2 + 1)) {
                ++changes;
                ++pointer2;
            } else {
                ++changes;
                ++pointer1;
                ++pointer2;
            }
        }


        if (!(pointer1 == passportLength && pointer2 == dbNameLength)) {
            ++changes;
        }

        return changes > 1 ? FAIL_ANSWER : OK_ANSWER;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String passportName = readString(reader);
            String dbName = readString(reader);
            System.out.println(customsControl(passportName, dbName));
        }
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

}