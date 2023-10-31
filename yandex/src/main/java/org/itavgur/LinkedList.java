package org.itavgur;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    public static class Node<T> {
        private final T value;
        private final Node<T> nextNode;
        private int count = 0;

        public Node(T value) {
            this.value = value;
            this.nextNode = null;
        }

        public Node(T value, Node<T> nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        public static <T> Node<T> init(T value) {
            return new Node<>(value, null);
        }

        public Node<T> next(T value) {
            Node<T> newNode = new Node<>(value, this);
            newNode.count = this.count + 1;
            return newNode;
        }

        @SuppressWarnings("unchecked")
        public T[] array() {

            T[] array = (T[]) Array.newInstance(value.getClass(), this.count + 1);

            Node<T> currentNode = this;
            for (int i = count; i >= 0; i--) {
                if (currentNode == null) break;
                array[i] = currentNode.value;
                currentNode = currentNode.nextNode;
            }
            return array;
        }

        public List<T> list() {

            List<T> list = new ArrayList<>(this.count + 1);

            Node<T> currentNode = this;
            for (int i = count; i >= 0; i--) {
                if (currentNode == null) break;
                list.add(currentNode.value);
                currentNode = currentNode.nextNode;
            }
            return list;
        }
    }

}
