package org.itavgur.sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/*
18 окт 2023, 19:58:28
93645619

-- ПРИНЦИП РАБОТЫ --

Преобразуем строки в массив объектов.
Это занимает память, но дает лучшую читаемость.
Сортируем список алгоритмом in-place и отдаем на выходе массив строк login.

Алгоритм выбора pivot - Random() индекса в пределах массива

Дополнительная память НЕ используется внутри алгоритма сортировки

Правила сортировки - внутри Person.class

Сортировка сделана в отдельном класса с generic

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Быстрая сортировка согласно описанию задачи.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Создание массива объектов Person[] = O(n)
Cам алгоритм сортировки O(nlogn)-O(n2)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Исходный массив O(n)
Результирующий массив O(n)
На создание объектов ?x0(n), где ? = какое-то количество памяти на хранение объекта

*/


public class FinalB {

    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            FinalB finalB = new FinalB();
            Integer membersCount = readInt(reader);
            String[] membersInfo = readStrings(reader, membersCount);
            String[] result = finalB.process(membersInfo);
            printArrayPerLine(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static String[] readStrings(BufferedReader reader, int rows) throws IOException {
        String[] res = new String[rows];
        for (int i = 0; i < rows; ++i) {
            res[i] = reader.readLine();
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

    public String[] process(String[] membersInfo) {

        Person[] infos = Person.getArray(membersInfo);

        InPlaceFastSort<Person> inPlaceFastSort = new InPlaceFastSort<>(infos);
        inPlaceFastSort.sort();

        return Arrays.stream(inPlaceFastSort.get()).map(Person::getLogin).toArray(String[]::new);
    }

    public static class InPlaceFastSort<T extends Comparable<T>> {

        private final T[] array;

        public InPlaceFastSort(T[] array) {
            this.array = array;
        }

        public T[] get() {
            return array;
        }

        public void sort() {
            sort(0, array.length - 1);
        }

        private void sort(int begin, int end) {

            if (begin == end) return;

            int leftIxd = begin;
            int rightIdx = end;

            int pivotIdx = (int) ((Math.random() * (rightIdx - leftIxd)) + leftIxd);
            T pivot = array[pivotIdx];

            while (leftIxd <= rightIdx) {
                if (array[leftIxd].compareTo(pivot) >= 0 && array[rightIdx].compareTo(pivot) <= 0) {
                    swap(array, leftIxd, rightIdx);
                    ++leftIxd;
                    --rightIdx;
                } else if (array[leftIxd].compareTo(pivot) <= 0) {
                    ++leftIxd;
                } else if (array[rightIdx].compareTo(pivot) >= 0) {
                    --rightIdx;
                }
            }

            sort(begin, rightIdx);
            sort(leftIxd, end);
        }

        private void swap(T[] array, int idx1, int idx2) {
            T tmp = array[idx1];
            array[idx1] = array[idx2];
            array[idx2] = tmp;
        }
    }

    public static class Person implements Comparable<Person> {
        private final String login;
        private final Integer task;
        private final Integer fine;

        public Person(String login, Integer task, Integer fine) {
            this.login = login;
            this.task = task;
            this.fine = fine;
        }

        public static Person[] getArray(String[] info) {
            return Arrays.stream(info)
                    .map(string -> {
                        String[] person = string.split(DELIMITER);
                        return new Person(person[0], Integer.parseInt(person[1]), Integer.parseInt(person[2]));
                    }).toArray(Person[]::new);
        }

        public String getLogin() {
            return login;
        }

        public Integer getTask() {
            return task;
        }

        public Integer getFine() {
            return fine;
        }

        @Override
        public int compareTo(Person person) {
            if (!this.getTask().equals(person.getTask())) {
                return person.getTask() - this.getTask();
            } else if (!this.getFine().equals(person.getFine())) {
                return this.getFine() - person.getFine();
            } else {
                return this.getLogin().compareTo(person.getLogin());
            }
        }
    }

}