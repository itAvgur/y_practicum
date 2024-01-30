package org.itavgur.sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task_K {

    private static final String DELIMITER = " ";

    protected static Integer[][] horoscopes(int sizeSeq1, Integer[] seq1, int sizeSeq2, Integer[] seq2) {

        int[][] matrix = new int[sizeSeq1 + 1][sizeSeq2 + 1];
        Arrays.fill(matrix[0], 0);

        for (int i = 1; i < sizeSeq1 + 1; i++) {
            int elem1 = seq1[i - 1];
            matrix[i][0] = 0;
            for (int j = 1; j < sizeSeq2 + 1; j++) {
                int elem2 = seq2[j - 1];
                if (elem1 == elem2) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }

        List<Integer> seq1path = new ArrayList<>();
        List<Integer> seq2path = new ArrayList<>();

        int i = sizeSeq1;
        int j = sizeSeq2;
        while (!(i == 0 || j == 0)) {
            if (seq1[i - 1].equals(seq2[j - 1])) {
                seq1path.add(i);
                seq2path.add(j);
                --i;
                --j;
            } else {

                if (matrix[i - 1][j] == matrix[i][j]) {
                    --i;
                } else {
                    --j;
                }
            }
        }

        Integer[][] result;
        if (seq1path.isEmpty()) {
            result = new Integer[][]{{0}};
        } else {
            result = new Integer[3][];
            result[0] = new Integer[]{seq1path.size()};
            Collections.reverse(seq1path);
            result[1] = seq1path.toArray(Integer[]::new);
            Collections.reverse(seq2path);
            result[2] = seq2path.toArray(Integer[]::new);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer sizeSeq1 = readInt(reader);
            Integer[] seq1 = readIntegers(reader);
            Integer sizeSeq2 = readInt(reader);
            Integer[] seq2 = readIntegers(reader);

            printMatrix(horoscopes(sizeSeq1, seq1, sizeSeq2, seq2));
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    private static void printMatrix(Integer[][] values) {
        PrintWriter output = new PrintWriter(System.out);
        for (Integer[] row : values) {
            for (Integer value : row) {
                output.print(value);
                output.print(DELIMITER);
            }
            output.println();
        }
        output.flush();
        output.close();
    }

}