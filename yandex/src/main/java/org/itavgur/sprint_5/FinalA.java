package org.itavgur.sprint_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
30 ноя 2023, 16:33:13
100552922

-- ПРИНЦИП РАБОТЫ --

Решение сделал с Generic, поэтому используется вспомогательная структура Node<T>

Сортировку делаем на массиве.
Первый этап: кладем по элементу в кучу и просеиваем этот элемент наверх пока не упремся в элемент меньше

Второй этап: меняем верхний элемент и элемент в конце кучи. Просеиваем верхний элемент вниз, пока не упремся в элемент
больше. Чтобы не попасть в же отсортированный элемент ограничиваем "сито" лимитом справа.

На выходе получаем heap в отсортированном в обратном порядке (мы сортировали по убыванию, а куча - по возрастанию)

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --

Используется стандартный описанный алгоритм с сортировкой на базе массива.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Две итерации
O(n*logN)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Используем оригинальный массив + вспомогательный класс + массив heap
Итого 3N

*/
public class FinalA {

    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            FinalA finalA = new FinalA();
            Integer membersCount = readInt(reader);
            String[] membersInfo = readStrings(reader, membersCount);
            String[] result = finalA.process(membersInfo);
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

        PyramidSorting<Person> pyramidSorting = new PyramidSorting<>(infos);
        pyramidSorting.sort();

        return pyramidSorting.getResult().stream().map(Person::getLogin).toArray(String[]::new);
    }

    public static class PyramidSorting<T extends Comparable<T>> {

        private final T[] array;
        private Node<T>[] heap;

        public PyramidSorting(T[] array) {
            this.array = array;
        }

        public List<T> getResult() {

            return IntStream.range(1, heap.length)
                    .mapToObj(idx -> heap[heap.length - idx].value)
                    .collect(Collectors.toList());

        }

        private void sort() {

            heap = new Node[array.length + 1];

            heapify();
            sortHeap();
        }

        private void sortHeap() {

            for (int i = heap.length - 1; i > 1; i--) {
                swap(1, i);
                siftDown(1, i - 1);
            }

        }

        private void heapify() {
            for (int i = 1; i < array.length + 1; i++) {
                Node<T> newNode = new Node<>(array[i - 1]);
                heap[i] = newNode;
                if (i / 2 < 1) continue;
                siftMinUp(i);
            }
        }

        private void siftMinUp(int idx) {

            if (idx == 1) return;

            if (heap[idx].value.compareTo(heap[idx / 2].value) < 0) {
                swap(idx, idx / 2);
                siftMinUp(idx / 2);
            }
        }

        private void siftDown(int idx, int limit) {

            int minIdx;

            if (idx * 2 > limit) {
                return;
            } else if (idx * 2 + 1 > limit) {
                minIdx = idx * 2;
            } else {
                minIdx = heap[idx * 2].value.compareTo(heap[idx * 2 + 1].value) < 0 ? idx * 2 : idx * 2 + 1;
            }

            if (heap[idx].value.compareTo(heap[minIdx].value) > 0) {
                swap(idx, minIdx);

                siftDown(minIdx, limit);
            }

        }

        private void swap(int idx1, int idx2) {

            Node<T> tmp = heap[idx1];
            heap[idx1] = heap[idx2];
            heap[idx2] = tmp;
        }

        private static class Node<T extends Comparable<T>> {

            T value;

            public Node(T value) {
                this.value = value;
            }
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