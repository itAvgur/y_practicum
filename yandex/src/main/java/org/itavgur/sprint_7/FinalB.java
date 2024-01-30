package org.itavgur.sprint_7;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
29 янв 2024, 13:25:11
106105941

-- ПРИНЦИП РАБОТЫ --

Подсчитывает сумму всех элементов массива.
Формирует матрицу matrix[n][s], где s=сумма всех элементов деленное напополам

Первая строка matrix[0] все элементы = 0, как и первые элементы строк
Далее для каждого значения пытаемся положить его в корзину.
Учитываем условия: исходные элемент один в корзине, исходные элемент прибавляется к уже имеющемуся/имеюшейся комбинации

Таким образом последня клетка matrix не должна быть 0, это значит что все элементы использованы

Для оптимизации памяти matrix свернута в 2 массива, поскольку одновременно мы  работаем только с двумя строками из массива.

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Жадный алгоритм в данном случае учитывает все возможные комбинации элементы и предыдущих.
Элементы не попадающие в исходную матрицу фактически попадают во вторую матрицу, мы их просто исключаем.
Критерием у нас является не определить возможный набор данных, а определить, что это в принципе возможно.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Подсчет суммы сделан отдельно O(n)

Заполнения матрицы O(n*s), где s=сумма всех элементов деленное напополам

Итого O(n*s)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Используется исходный массив данных и два вспомогательных массива длинной sum всех значений массива.


*/
public class FinalB {

    private static final String POSITIVE_ANSWER = "True";
    private static final String NEGATIVE_ANSWER = "False";

    public static String process(int size, Integer[] data) {

        if (size == 0) {
            return POSITIVE_ANSWER;
        }

        int sum = Arrays.stream(data).reduce(Integer::sum).orElseThrow();

        if (sum % 2 != 0) return NEGATIVE_ANSWER;

        int[] currentLine = new int[(sum / 2) + 1];
        int[] previousLine;
        Arrays.fill(currentLine, 0);

        for (int value : data) {
            previousLine = Arrays.copyOf(currentLine, (sum / 2) + 1);
            currentLine[0] = 0;

            for (int j = 1; j < currentLine.length; j++) {
                if (j == value) {
                    currentLine[j] = value;
                } else if (j - value < 0) {
                    currentLine[j] = previousLine[j];
                } else {
                    currentLine[j] = Math.max(previousLine[j], previousLine[j - value]);
                }
            }

        }

        return currentLine[(sum / 2)] > 0 ? POSITIVE_ANSWER : NEGATIVE_ANSWER;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int size = readInt(reader);
            Integer[] data = readData(reader);
            System.out.println(process(size, data));
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    protected static Integer[] readData(Reader reader) throws IOException {
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

}