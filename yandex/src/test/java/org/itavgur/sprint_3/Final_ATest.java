package org.itavgur.sprint_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Final_ATest {

    @Test
    public void test() {

        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12, 13, 15, 17};
        System.out.println(FinalA.brokenSearch(arr, 1));

        int[] ar = {100, 1, 30, 50};
        Assertions.assertEquals(-1, FinalA.brokenSearch(ar, 4));

        int[] arrf = {3, 5, 6, 7, 9, 1, 2};
        Assertions.assertEquals(-1, FinalA.brokenSearch(arrf, 4));

        int[] arr2 = {19, 21, 100, 101, 1, 4, 5, 7, 12};
        Assertions.assertEquals(6, FinalA.brokenSearch(arr2, 5));

        int[] arr0 = {100, 101, 1, 4, 5, 7, 12, 19, 21};
        assert 4 == FinalA.brokenSearch(arr0, 5);

        int[] arr1 = {5, 1};
        assert 1 == FinalA.brokenSearch(arr1, 1);

        int[] arrHuge = {3271, 3298, 3331, 3397, 3407, 3524, 3584, 3632, 3734, 3797, 3942, 4000, 4180, 4437, 4464, 4481, 4525, 4608, 4645, 4803, 4804, 4884, 4931, 4965, 5017, 5391, 5453, 5472, 5671, 5681, 5959, 6045, 6058, 6301, 6529, 6621, 6961, 7219, 7291, 7372, 7425, 7517, 7600, 7731, 7827, 7844, 7987, 8158, 8169, 8265, 8353, 8519, 8551, 8588, 8635, 9209, 9301, 9308, 9336, 9375, 9422, 9586, 9620, 9752, 9776, 9845, 9906, 9918, 16, 25, 45, 152, 199, 309, 423, 614, 644, 678, 681, 725, 825, 830, 936, 1110, 1333, 1413, 1617, 1895, 1938, 2107, 2144, 2184, 2490, 2517, 2769, 2897, 2970, 3023, 3112, 3156};
        Assertions.assertEquals(69, FinalA.brokenSearch(arrHuge, 25));
    }

}