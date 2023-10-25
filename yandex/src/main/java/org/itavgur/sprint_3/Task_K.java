package org.itavgur.sprint_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_K {
    public static int[] merge(int[] arr, int left, int mid, int right) {

        List<Integer> result = new ArrayList<>();

        int leftIdx = left;
        int midIdx = mid;
        while (leftIdx < mid && midIdx < right) {
            if (arr[leftIdx] <= arr[midIdx]) {
                result.add(arr[leftIdx]);
                ++leftIdx;
            } else {
                result.add(arr[midIdx]);
                ++midIdx;
            }
        }
        if (leftIdx < mid) {
            for (int i = leftIdx; i < mid; i++) {
                result.add(arr[i]);
            }
        } else if (midIdx < right) {
            for (int i = midIdx; i < right; i++) {
                result.add(arr[i]);
            }
        }

        for (Integer i : result) {
            arr[left] = i;
            ++left;
        }
        return arr;
    }

    public static void merge_sort(int[] arr, int left, int right) {

        if (right - left == 0 || right - left == 1) {
            return;
        }

        int middle = left + ((right - left) / 2);

        merge_sort(arr, left, middle);
        merge_sort(arr, middle, right);

        int[] arrSorted = merge(arr, left, middle, right);

        if (right - left >= 0) System.arraycopy(arrSorted, left, arr, left, right - left);

    }

    public static void main(String[] args) {
        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);
        int[] c = {1, 4, 2, 10, 1, 2};
        merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert Arrays.equals(c, expected2);
    }
}