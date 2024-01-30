package org.itavgur.sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/*
26 янв 2024, 15:50:31
105895399

-- ПРИНЦИП РАБОТЫ --
Используем матрицу, построчно заполняем сравнивая буквы из строк.
Первая строка в таблице - ариф.прогрессия от 0 до длины первого слова
Количество строк - длина первого слова.

Правило заполнения:
    if STR2(i) = STR1(j), then (i,j) = Min((i-1,j-1)+1, (i-1,j)+1, (i,j-1)+1)
    else (i,j) = Min((i-1,j-1), (i-1,j)+1, (i,j-1)+1)

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --

Инкремент значения в ячейке, происходит при обработке новой буквы когда буква не совпадает.

Когда буквы совпадает, то инкрементировать счетчик не надо, берем его значение из ячейки (i-1,j-1)
Вот этот момент сам не смог до конца придумать, пришлось подсказку смотреть ))

Описание алгоритма https://habr.com/ru/articles/569444/

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
O(M*N) M - длина первого слова, N - длина второго слова

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
N+M+(N*M), используем только одну матрицу
*/
public class FinalA {

    public static int process(String string1, String string2) {

        int[][] matrix = new int[string2.length() + 1][string1.length() + 1];
        matrix[0] = IntStream.range(0, string1.length() + 1).toArray();

        for (int i = 1; i <= string2.length(); i++) {
            matrix[i][0] = i;
            char letter1 = string2.charAt(i - 1);

            for (int j = 1; j <= string1.length(); j++) {
                char letter2 = string1.charAt(j - 1);

                if (letter1 == letter2) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i][j - 1] + 1, matrix[i - 1][j] + 1));
                } else {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1] + 1, Math.min(matrix[i][j - 1] + 1, matrix[i - 1][j] + 1));
                }
            }
        }

        return matrix[string2.length()][string1.length()];
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String string1 = readString(reader);
            String string2 = readString(reader);
            System.out.println(process(string1, string2));
        }
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

}