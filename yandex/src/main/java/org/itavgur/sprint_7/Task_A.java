package org.itavgur.sprint_7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task_A {

    protected static int process(int size, Integer[] prices) {

        boolean isHave = false;
        int have = 0;
        int previousPrice = prices[0];
        int summ = 0;

        for (int i = 1; i < prices.length; i++) {
            Integer currentPrice = prices[i];

            //buy
            if (!isHave) {
                if (previousPrice < currentPrice) {
                    have = previousPrice;
                    isHave = true;
                }
            }

            //sell
            if (isHave) {
                //sell the last one
                if (i == prices.length - 1) {
                    summ += (currentPrice - have);
                    break;
                }
                //try to sell
                if (currentPrice >= prices[i + 1]) {
                    summ += (currentPrice - have);
                    have = 0;
                    previousPrice = prices[i + 1];
                    ++i;
                    isHave = false;
                } else {
                    previousPrice = currentPrice;
                }
            } else {
                previousPrice = currentPrice;
            }
        }
        return summ;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer size = readInt(reader);
            Integer[] data = readData(reader);

            System.out.println(process(size, data));
        }
    }

    public static Integer[] readData(Reader reader) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(reader);
        List<Integer> tokens = new ArrayList<>();

        int currentToken = streamTokenizer.nextToken();
        while (currentToken != StreamTokenizer.TT_EOF) {

            if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                tokens.add((int) streamTokenizer.nval);
            }
            currentToken = streamTokenizer.nextToken();
        }
        return tokens.toArray(Integer[]::new);
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}