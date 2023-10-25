package org.itavgur;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private static int[] merge(int[] arr, int left, int mid, int right) {

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

    public static void mergeSort(int[] arr, int left, int right) {

        if (right - left == 0 || right - left == 1) {
            return;
        }

        int middle = left + ((right - left) / 2);

        mergeSort(arr, left, middle);
        mergeSort(arr, middle, right);

        int[] arrSorted = merge(arr, left, middle, right);

        if (right - left >= 0) System.arraycopy(arrSorted, left, arr, left, right - left);

    }

}