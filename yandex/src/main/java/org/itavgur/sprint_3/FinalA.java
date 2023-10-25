package org.itavgur.sprint_3;

/*
17 окт 2023, 14:05:15
93439331

-- ПРИНЦИП РАБОТЫ --
В цикле делим массива поровну, проверяем среднее значение.
Если не совпало, то проверям что крайние значения левого и правого массивов меньше/больше среднего.
Так определяем какой массив отсортирован, правый или левый.
Далее смотрим на крайние значения в отсортированном массиве.
Если наше искомое значения попадает в диапазон, то продолжаем искать в этом массиве.
Если нет - то ищем в другом массиве.
Повторяем пока leftIdx <= rightIdx

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Имеем 2 кейса:
1) массив по прежнему отсортирован, тогда простой бинарный поиск приведен нас к искомому значению
2) имеем разрыв, тогда у нас образуется 2 массива и ОДИН из них отсортирован, а другой нет.
Мы можем понять какой  массив отсортирован и проверить попадает ли наше значение в этот массив и выбрать его
для дальнейшего поиска. Или выбрать другой массив.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Каждый шаг итерации уменьшает массив для поиска в 2 раза.
В итоге имеем O(logn)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Используем тот же массив, поэтому O(n)

*/
public class FinalA {

    private static final Integer NOT_FOUND_RESPONSE = -1;

    public static int brokenSearch(int[] arr, int targetNumber) {

        int leftIdx = 0;
        int rightIdx = arr.length - 1;

        while (leftIdx <= rightIdx) {

            int pivotIdx = (leftIdx + rightIdx) / 2;
            int pivot = arr[pivotIdx];

            if (pivot == targetNumber) return pivotIdx;

            if (arr[leftIdx] <= pivot) {

                if (arr[leftIdx] <= targetNumber && targetNumber < pivot) {
                    rightIdx = pivotIdx - 1;
                } else {
                    leftIdx = pivotIdx + 1;
                }
            } else {
                if (arr[rightIdx] >= targetNumber && targetNumber > pivot) {
                    leftIdx = pivotIdx + 1;
                } else {
                    rightIdx = pivotIdx - 1;
                }
            }
        }
        return NOT_FOUND_RESPONSE;
    }

    private static void test() {
        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
        assert 6 == brokenSearch(arr, 5);
    }

}