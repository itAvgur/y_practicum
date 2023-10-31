package org.itavgur.sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/*
29 окт 2023, 09:55:32
95050033

-- ПРИНЦИП РАБОТЫ --

Отдельный класс HashTable.
При создании можем задать capacity
Для default значения я использовал простое число  1009
При меньшем значении тесты падали с TL.
Думаю, что правильный вариант это расчитывать capacity как простое число, исходя из количества команд.

Внутри используется массив с java generic
Метода разрешение коллизий: - цепочка объектов Node, которая является двухсвязным списком

Операции put,get,ready: операции над элементами списка и ячейкой массива (в случае, когда это первый или последний элемент в basket)

Определение basket: остаток от деления

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Используется стандартный метод цепочек с двухсвязным списком
Используется нативный hashcode() java
При грамотном выборе capacity получает необходимую производительность.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
2 кейса:
1) корзина пуста или последний элемент в корзине
 все операции O(1)
2) корзина не пуста (есть коллизии по хешу)
 все операции осуществляют поиск в корзине
 в худщем случае, если все элементы упали в одну корзину и искомый элемент последний - получаем O(n)
 а сами операции вставки, изменения и удаления O(1)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Максимум массив 0(K), где K - количество комманд,
где К = объект Node (Int + Int + LinkToObject + LinkToObject)
*/


public class FinalB {

    private static final String DELIMITER = " ";
    private static final String PUT_CMD = "put";
    private static final String GET_CMD = "get";
    private static final String DELETE_CMD = "delete";
    private static final String ELEMENT_NOT_FOUND = "None";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            FinalB finalB = new FinalB();
            int membersCount = readInt(reader);
            String[] commands = readStrings(reader, membersCount);
            String[] result = finalB.process(membersCount, commands);
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

    public String[] process(int membersCount, String[] commands) {

        HashTable<Integer, Integer> hashTable = new HashTable<>();
        List<String> output = new ArrayList<>();

        for (String command : commands) {
            String[] parsedCommand = command.split(DELIMITER);
            if (PUT_CMD.equals(parsedCommand[0])) {
                hashTable.put(Integer.parseInt(parsedCommand[1]), Integer.parseInt(parsedCommand[2]));
            } else if (GET_CMD.equals(parsedCommand[0])) {
                Integer value = hashTable.get(Integer.parseInt(parsedCommand[1]));
                output.add(value == null ? ELEMENT_NOT_FOUND : "" + value);
            } else if (DELETE_CMD.equals(parsedCommand[0])) {
                Integer deletedValue = hashTable.delete(Integer.parseInt(parsedCommand[1]));
                output.add(deletedValue == null ? ELEMENT_NOT_FOUND : "" + deletedValue);
            } else {
                throw new RuntimeException("Unknown command");
            }
        }
        return output.toArray(String[]::new);
    }

    @SuppressWarnings("unchecked")
    public static class HashTable<K, V> {

        private final static int DEFAULT_CAPACITY = 1009;
        private final Node<K, V>[] table;
        private final int capacity;

        public HashTable() {
            this(DEFAULT_CAPACITY);
        }

        public HashTable(int capacity) {
            table = new Node[capacity];
            this.capacity = capacity;
        }

        public void put(K key, V value) {
            int basketNumber = calcHash(key) % capacity;
            Node<K, V> lastNode = table[basketNumber];

            if (lastNode == null) {
                Node<K, V> newNode = new Node<>();
                newNode.key = key;
                newNode.value = value;
                table[basketNumber] = newNode;
            } else {
                Node<K, V> node = findNodeInBasket(lastNode, key);
                if (node == null) {
                    Node<K, V> newNode = new Node<>();
                    newNode.key = key;
                    newNode.value = value;
                    newNode.nextSibling = lastNode;
                    lastNode.previousSibling = newNode;
                    table[basketNumber] = newNode;
                } else {
                    node.value = value;
                }
            }
        }

        public V get(K key) {
            Node<K, V> lastNode = table[calcHash(key) % capacity];

            Node<K, V> node = findNodeInBasket(lastNode, key);
            return node == null ? null : node.value;
        }

        public V delete(K key) {
            int basketNumber = calcHash(key) % capacity;
            Node<K, V> lastNode = table[basketNumber];

            Node<K, V> node = findNodeInBasket(lastNode, key);
            if (node == null) {
                return null;
            } else {
                Node<K, V> nextSibling = node.nextSibling;
                Node<K, V> previousSibling = node.previousSibling;
                if (nextSibling != null && previousSibling != null) {
                    previousSibling.nextSibling = nextSibling;
                    nextSibling.previousSibling = previousSibling;
                } else if (nextSibling != null) {
                    nextSibling.previousSibling = null;
                    table[basketNumber] = nextSibling;
                } else if (previousSibling != null) {
                    previousSibling.nextSibling = null;
                } else {
                    table[basketNumber] = null;
                }

            }
            return node.value;
        }

        private int calcHash(K key) {
            return Math.abs(key.hashCode());
        }

        private Node<K, V> findNodeInBasket(Node<K, V> node, K key) {

            Node<K, V> currentNode = node;
            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    return currentNode;
                } else {
                    currentNode = currentNode.nextSibling;
                }
            }
            return null;
        }

        private static class Node<K, V> {
            private K key;
            private V value;
            private Node<K, V> nextSibling;
            private Node<K, V> previousSibling;

        }

    }

}