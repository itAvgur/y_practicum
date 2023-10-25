package org.itavgur;

public class InPlaceFastSort<T extends Comparable<T>> {

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

        int pivotIdx = (leftIxd + rightIdx) / 2;
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