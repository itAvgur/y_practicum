package org.itavgur.sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
1 фев 2024, 17:59:41
106395163

-- ПРИНЦИП РАБОТЫ --
Используется класс StringUnpacker с массивом запакованных строк.
Метод unpackString() запускает процесс распаковки, результат сохраняется в доп. массиве.
Для каждого символа используется сравнение: если число и следующий символ = открывающая скобка, то рекурсивно запускает
сканирование содержимого, до тех пор, пока не будет найдена закрывающая скобка.
Результат умножается на цифру перед открывающей скобкой.
Все промежуточные результаты хранятся в экземплярах StringBuilder, в итого формируем char[], которые складываем.

В итоге распакованные слова сравниваются посимвольно и мы получаем величину максимального префикса.

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Основной цикл позволяет сканировать все символы, и буквы и цифры.
Рекурсия позволяет распаковывать содержимое.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
O(n) - используется общая переменная position, итерируемая внутри нескольких циклов/вызовов рекурсий

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Массив исходных слов.
Массив распакованных слов.
Промежуточные массивы для сбора символов в рекурсии.
Итоговый результат зависит от содержимого слов
Можно утверждать, что (n*l*2), где l - максимально длинное слово при распаковкe
*/
public class FinalA {

    private static final char OPENING_PACKED_SEQUENCE_SYMBOL = '[';
    private static final char CLOSING_PACKED_SEQUENCE_SYMBOL = ']';

    public static String process(int number, String[] strings) {

        StringUnpacker stringUnpacker = new StringUnpacker(strings);

        stringUnpacker.unpackString();

        int maxPrefixLength = findMinPrefixLength(stringUnpacker.unpackedStrings);

        return stringUnpacker.unpackedStrings[0].substring(0, maxPrefixLength);
    }

    private static int findMinPrefixLength(String[] unpackedStrings) {

        int minLength = Arrays.stream(unpackedStrings).map(String::length).reduce(Integer::min).orElse(0);

        int maxPrefix = 0;
        for (int i = 0; i < minLength; i++) {
            boolean isOk = true;
            char letter = unpackedStrings[0].charAt(i);
            for (String string : unpackedStrings) {
                if (string.charAt(i) != letter) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                ++maxPrefix;
            } else {
                break;
            }
        }

        return maxPrefix;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int number = readInt(reader);
            String[] packedStrings = readStrings(reader, number);
            System.out.println(process(number, packedStrings));
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
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

    private static class StringUnpacker {

        private final String[] packedStrings;
        private String[] unpackedStrings;
        private int position = 0;

        public StringUnpacker(String[] packedStrings) {
            this.packedStrings = packedStrings;
        }

        public void unpackString() {

            unpackedStrings = new String[packedStrings.length];

            for (int i = 0; i < packedStrings.length; i++) {

                if (packedStrings[i].isBlank()) continue;
                position = 0;

                StringBuilder sb = new StringBuilder();
                while (position < packedStrings[i].length()) {
                    char[] str = unpackRecursively(packedStrings[i]);
                    sb.append(str);
                }

                unpackedStrings[i] = sb.toString();
            }

        }

        private char[] unpackRecursively(String word) {

            StringBuilder sb = new StringBuilder();

            while (position < word.length()) {

                char symbol = word.charAt(position);
                if (Character.isDigit(symbol) && position + 1 < word.length()
                        && word.charAt(position + 1) == OPENING_PACKED_SEQUENCE_SYMBOL) {

                    position += 2;
                    sb.append(repeatArray(unpackRecursively(word), Character.getNumericValue(symbol)));
                    ++position;

                } else if (symbol == CLOSING_PACKED_SEQUENCE_SYMBOL) {
                    return getCharArray(sb);

                } else {
                    ++position;
                    sb.append(symbol);
                }

            }
            return getCharArray(sb);
        }

        private char[] repeatArray(char[] array, int times) {
            char[] newChars = new char[times * array.length];
            for (int i = 0; i < times; i++) {
                System.arraycopy(array, 0, newChars, array.length * i, array.length);
            }

            return newChars;
        }

        private char[] getCharArray(StringBuilder stringBuilder) {

            char[] newCharArray = new char[stringBuilder.length()];
            stringBuilder.getChars(0, stringBuilder.length(), newCharArray, 0);
            return newCharArray;

        }

    }
}