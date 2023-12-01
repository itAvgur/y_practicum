package org.itavgur.sprint_5;

public class Task_L {
    public static int siftDown(int[] heap, int idx) {

        int value = heap[idx];
        if (idx * 2 > heap.length - 1) return idx;
        int valueLeft = heap[idx * 2];

        int valueRight = Integer.MIN_VALUE;
        if (idx * 2 + 1 <= heap.length - 1) {
            valueRight = heap[idx * 2 + 1];
        }


        if (value > valueLeft && value > valueRight) return idx;

        if ((value < valueLeft && value > valueRight)
                || (value < valueLeft && value < valueRight && valueLeft > valueRight)) {
            //left
            heap[idx] = valueLeft;
            heap[idx * 2] = value;
            return siftDown(heap, idx * 2);
        }

        if ((value > valueLeft && value < valueRight)
                || (value < valueLeft && value < valueRight && valueLeft < valueRight)) {
            //right
            heap[idx] = valueRight;
            heap[idx * 2 + 1] = value;
            return siftDown(heap, idx * 2 + 1);
        }

        //we never archive this return
        return 0;
    }

}