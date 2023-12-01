package org.itavgur.sprint_5;

public class Task_M {
    public static int siftUp(int[] heap, int idx) {

        if (idx == 1) return 1;

        int current = heap[idx];
        int parent = heap[idx / 2];

        if (parent >= current) return idx;

        heap[idx / 2] = current;
        heap[idx] = parent;

        return siftUp(heap, idx / 2);

    }

}