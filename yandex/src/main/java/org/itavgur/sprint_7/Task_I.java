package org.itavgur.sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Task_I {

    private static final String DELIMITER = " ";

    protected static String[] maxFlowersPath(int sizeX, int sizeY, String[] field) {

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

        StringBuilder moves = new StringBuilder();

        int row = sizeX;
        int column = sizeY;
        while (!(row == 1 && column == 1)) {

            int left = res[row][column - 1];
            int down = res[row - 1][column];

            if (left >= down && column != 1) {
                moves.append("R");
                --column;
            } else {
                moves.append("U");
                --row;
            }
        }

        String[] resArray = new String[2];

        resArray[0] = "" + res[sizeX][sizeY];
        resArray[1] = moves.reverse().toString();

        return resArray;
    }


    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] sizes = readIntegers(reader);
            String[] field = readStrings(reader, sizes[0]);
            printArrayPerLine(maxFlowersPath(sizes[0], sizes[1], field));
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

    private static void printArrayPerLine(String[] strings) {
        PrintWriter output = new PrintWriter(System.out);
        for (String string : strings) {
            output.println(string);
        }
        output.flush();
        output.close();
    }

}