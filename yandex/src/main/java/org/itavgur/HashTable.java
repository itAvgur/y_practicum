package org.itavgur;

public class HashTable<K, V> {

    private final static int DEFAULT_CAPACITY = 1009;
    private final Node<K, V>[] table;
    private final int capacity;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        table = new Node[capacity];
        this.capacity = capacity;
    }

    public void put(K key, V value) {
        int basketNumber = calcHash(key) % capacity;
        Node<K, V> lastNode = table[basketNumber];

        if (lastNode == null) {
            Node<K, V> newNode = new Node<>();
            newNode.key = key;
            newNode.value = value;
            table[basketNumber] = newNode;
        } else {
            Node<K, V> node = findNodeInBasket(lastNode, key);
            if (node == null) {
                Node<K, V> newNode = new Node<>();
                newNode.key = key;
                newNode.value = value;
                newNode.nextSibling = lastNode;
                lastNode.previousSibling = newNode;
                table[basketNumber] = newNode;
            } else {
                node.value = value;
            }
        }
    }

    public V get(K key) {
        Node<K, V> lastNode = table[calcHash(key) % capacity];

        Node<K, V> node = findNodeInBasket(lastNode, key);
        return node == null ? null : node.value;
    }

    public V delete(K key) {
        int basketNumber = calcHash(key) % capacity;
        Node<K, V> lastNode = table[basketNumber];

        Node<K, V> node = findNodeInBasket(lastNode, key);
        if (node == null) {
            return null;
        } else {
            Node<K, V> nextSibling = node.nextSibling;
            Node<K, V> previousSibling = node.previousSibling;
            if (nextSibling != null && previousSibling != null) {
                previousSibling.nextSibling = nextSibling;
                nextSibling.previousSibling = previousSibling;
            } else if (nextSibling != null) {
                nextSibling.previousSibling = null;
                table[basketNumber] = nextSibling;
            } else if (previousSibling != null) {
                previousSibling.nextSibling = null;
            } else {
                table[basketNumber] = null;
            }

        }
        return node.value;
    }

    private int calcHash(K key) {
        return Math.abs(key.hashCode());
    }

    private Node<K, V> findNodeInBasket(Node<K, V> node, K key) {

        Node<K, V> currentNode = node;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode;
            } else {
                currentNode = currentNode.nextSibling;
            }
        }
        return null;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> nextSibling;
        private Node<K, V> previousSibling;

    }

}
