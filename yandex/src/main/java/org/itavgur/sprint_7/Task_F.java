package org.itavgur.sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_F {

    private static final String DELIMITER = " ";
    private static final int MOD = 1000000007;

    protected static int jumps(int steps, int maxJump) {

        long[] res = new long[steps];

        res[0] = 1;

        for (int i = 1; i < res.length; i++) {

            long sum = 0;

            for (int j = 0; j < maxJump; j++) {
                if (i - j - 1 < 0) continue;
                sum += res[i - 1 - j];
            }

            res[i] = sum % MOD;
        }

        return (int) res[steps - 1];
    }


    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] data = readIntegers(reader);
            System.out.println(jumps(data[0], data[1]));
        }
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

}