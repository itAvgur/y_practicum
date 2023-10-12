package org.itavgur.sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/*
11 окт 2023, 11:58:04
92666846

-- ПРИНЦИП РАБОТЫ --
deq реализовано на кольцевом буфере в соотвествии с условием задачи
Из условия к числам выбраны Integer
Дополнительные условия:
    Если currentSize=0 то мы не двигаем голову и хвост, они продолжают указывать на прежний элемент, но мы увеличиваем текущий размер.
    Если мы выходим на границу буфера (проходим круг), то отдельным условием определяем будующее значение головы/хвоста

    Возврат null из popFront/popBack означает ошибку, exception здесь решил не делать

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Фактически мы имеем дело с обычным массивом, в котором выход за границу массива с любои из сторон приводит не к расширению массива,
а к проверке условия на maxQueue и к специфической обработке указателей head/tail.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Все операции O(1), потому что мы храним указатели на голову/хвост в отдельных переменных.
Итого алгоритм целиком O(n)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Буфер O(n) + 3 переменные (указатели головы/хвоста, длина очереди)
Итого O(n)

*/

public class FinalA {

    private static final String DELIMITER = " ";
    private static final String PUSH_BACK = "push_back";
    private static final String PUSH_FRONT = "push_front";
    private static final String POP_FRONT = "pop_front";
    private static final String POP_BACK = "pop_back";
    private static final String ERROR_MSG = "error";

    public static String[] process(String[] commands, int queueSize) {

        Dequeue dequeue = new Dequeue(queueSize);

        List<String> output = new ArrayList<>();
        for (String s : commands) {
            String[] command = s.split(DELIMITER);
            if (PUSH_FRONT.equals(command[0])) {
                if (!dequeue.pushFront(Integer.parseInt(command[1]))) {
                    output.add(ERROR_MSG);
                }
            } else if (PUSH_BACK.equals(command[0])) {
                if (!dequeue.pushBack(Integer.parseInt(command[1]))) {
                    output.add(ERROR_MSG);
                }
            } else if (POP_BACK.equals(command[0])) {
                Integer result = dequeue.popBack();
                if (result == null) {
                    output.add(ERROR_MSG);
                } else {
                    output.add("" + result);
                }
            } else if (POP_FRONT.equals(command[0])) {
                Integer result = dequeue.popFront();
                if (result == null) {
                    output.add(ERROR_MSG);
                } else {
                    output.add("" + result);
                }
            } else {
                throw new RuntimeException("unknown operation");
            }
        }
        return output.toArray(String[]::new);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int commandSize = readInt(reader);
            int queueSize = readInt(reader);
            String[] commands = readStringsPerLine(reader, commandSize);
            String[] result = process(commands, queueSize);
            printArrayPerLine(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static void printArrayPerLine(String[] strings) {
        PrintWriter output = new PrintWriter(System.out);
        for (String string : strings) {
            output.println(string);
        }
        output.flush();
        output.close();
    }

    private static String[] readStringsPerLine(BufferedReader reader, int size) throws IOException {
        String[] res = new String[size];
        for (int i = 0; i < size; i++) {
            res[i] = reader.readLine();
        }
        return res;
    }

    public static class Dequeue {

        private final Integer[] queue;
        private int head = 0;
        private int tail = 0;
        private int currentSize = 0;

        public Dequeue(int queueSize) {
            this.queue = new Integer[queueSize];
        }

        public boolean pushFront(int value) {
            if (currentSize == queue.length) {
                return false;
            } else {
                if (currentSize > 0) {
                    head = (head + 1) % queue.length;
                }
                queue[head] = value;
                ++currentSize;
                return true;
            }
        }

        public boolean pushBack(int value) {
            if (currentSize == queue.length) {
                return false;
            } else {
                if (currentSize > 0) {
                    tail = tail == 0 ? (queue.length - 1) : (tail - 1) % queue.length;
                }
                queue[tail] = value;
                ++currentSize;
                return true;
            }
        }

        public Integer popFront() {
            Integer result;
            if (currentSize == 0) {
                result = null;
            } else {
                result = queue[head];
                --currentSize;
                if (currentSize > 0) {
                    head = head == 0 ? (queue.length - 1) : (head - 1) % queue.length;
                }
            }
            return result;
        }

        public Integer popBack() {
            Integer result;
            if (currentSize == 0) {
                result = null;
            } else {
                result = queue[tail];
                --currentSize;
                if (currentSize > 0) {
                    tail = (tail + 1) % queue.length;
                }
            }
            return result;
        }

    }
}