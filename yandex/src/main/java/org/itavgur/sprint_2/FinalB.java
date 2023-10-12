package org.itavgur.sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
10 окт 2023, 13:47:05
92548306

-- ПРИНЦИП РАБОТЫ --
Согласно условиям задачи реализовано на стеке
Стек реализован на ArrayList, который, в свою очередь, на массиве.

Кладем операции в стек пока не встретим символ ар. операции.
Вынимаем из стека 2 числа, проводит вычисления и кладем результат обратно на стек.

В итоге на стеке оказывается число - результат всех операции

Обработаны случаи: пустые входные данные

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Каждая ар. операция работает с 2 числами.
Алгоритм будет корректен, если ар.знак идет минимум после 2 чисел, которые в свою очередь мы получаем из
исходного массива+результат предыдущих вычислений.
Количество операций + 1 = количество цифр


-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Каждый елемент обрабатывается 2 раза (положили, взяли)
Кроме того, каждая операция приводят к обработке еще одного элемента, результата вычислении
Так же возможны операции расширения массива в ArrayList
Итого, отбрасывая все константы =  O(n)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Все операции выполняются в одной структуре, поэтому  - O(n)

*/

public class FinalB {

    private static final String DELIMITER = " ";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    private List<Integer> stack = null;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            FinalB finalB = new FinalB();
            String[] commands = readStrings(reader);
            Integer result = finalB.process(commands);
            System.out.println(result);
        }
    }

    private static String[] readStrings(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .toArray(String[]::new);
    }

    public Integer process(String[] commands) {

        stack = new ArrayList<>();
        if (commands.length == 0) return null;

        for (String value : commands) {
            if (PLUS.equals(value)) {
                push(pop() + pop());
            } else if (MINUS.equals(value)) {
                Integer op1 = pop();
                Integer op2 = pop();
                push(op2 - op1);
            } else if (MULTIPLY.equals(value)) {
                Integer op1 = pop();
                Integer op2 = pop();
                push(op2 * op1);
            } else if (DIVIDE.equals(value)) {
                Integer op1 = pop();
                Integer op2 = pop();
                push(Math.floorDiv(op2, op1));
            } else {
                push(Integer.parseInt(value));
            }
        }

        return stack.get(stack.size() - 1);
    }

    private void push(Integer value) {
        stack.add(value);
    }

    private Integer pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }


}