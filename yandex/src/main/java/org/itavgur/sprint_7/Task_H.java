package org.itavgur.sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_H {

    private static final String DELIMITER = " ";

    protected static int maxFlowersSearch(int sizeX, int sizeY, String[] field) {

        int[][] res = new int[sizeX + 1][sizeY + 1];
        Arrays.fill(res[0], 0);

        for (int i = 1; i < res.length; i++) {
            int[] row = res[i];
            row[0] = 0;

            for (int j = 1; j < row.length; j++) {
                int isFlower = field[sizeX - i].charAt(j - 1) == '1' ? 1 : 0;

                row[j] = Math.max(row[j - 1], res[i - 1][j]) + isFlower;
            }

        }

        return res[sizeX][sizeY];
    }


    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] sizes = readIntegers(reader);
            String[] field = readStrings(reader, sizes[0]);
            System.out.println(maxFlowersSearch(sizes[0], sizes[1], field));
        }
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    private static String[] readStrings(BufferedReader reader, int rows) throws IOException {
        String[] res = new String[rows];
        for (int i = 0; i < rows; ++i) {
            String value = readString(reader);
            res[i] = value;
        }
        return res;
    }


}