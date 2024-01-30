package org.itavgur.sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task_C {

    private static final String DELIMITER = " ";

    protected static long gold(int capacity, int goldTotal, Integer[][] data) {

        List<Gold> golds = initGold(data);

        int finalAmount = 0;
        long finalCost = 0;

        for (Gold gold : golds) {
            int willTake = Math.min(capacity - finalAmount, gold.amount);

            finalAmount += willTake;
            finalCost += willTake * gold.cost;
            gold.amount -= finalAmount;

            if (capacity == 0) break;
        }

        return finalCost;
    }

    private static List<Gold> initGold(Integer[][] data) {

        List<Gold> res = new ArrayList<>();

        for (Integer[] datum : data) {
            res.add(new Gold(datum[1], datum[0]));
        }

        res.sort(new GoldComparator());


        return res;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int capacity = readInt(reader);
            int goldTotal = readInt(reader);
            Integer[][] gold = readMatrix(reader, goldTotal, 2);

            System.out.println(gold(capacity, goldTotal, gold));
        }
    }

    private static Integer[] readIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    protected static Integer[][] readMatrix(BufferedReader reader, int rows, int columns) throws IOException {
        Integer[][] res = new Integer[rows][columns];
        for (int i = 0; i < rows; ++i) {
            Integer[] integers = readIntegers(reader);
            res[i] = integers;
        }
        return res;
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static class Gold {
        int amount;
        long cost;

        public Gold(int amount, int cost) {
            this.amount = amount;
            this.cost = cost;
        }
    }

    private static class GoldComparator implements Comparator<Gold> {
        @Override
        public int compare(Gold o1, Gold o2) {
            return Math.toIntExact(o2.cost - o1.cost);
        }
    }

}