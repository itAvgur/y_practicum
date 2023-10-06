package org.itavgur.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_H {

    public static String process(String str1, String str2) {

        int length = Math.max(str1.length(), str2.length());
        StringBuilder sb = new StringBuilder();

        String n1 = new StringBuilder(str1).reverse().toString();
        String n2 = new StringBuilder(str2).reverse().toString();

        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (i < n1.length()) {
                sum += n1.charAt(i) - '0';
            }

            if (i < n2.length()) {
                sum += n2.charAt(i) - '0';
            }

            switch (sum) {
                case 0:
                    sb.append("0");
                    break;
                case 1:
                    sb.append("1");
                    --sum;
                    break;
                case 2:
                    sb.append("0");
                    --sum;
                    break;
                case 3:
                    sb.append("1");
                    --sum;
                    --sum;
                    break;
            }

        }
        if (sum == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();
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