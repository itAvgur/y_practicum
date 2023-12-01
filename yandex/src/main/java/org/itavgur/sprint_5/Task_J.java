package org.itavgur.sprint_5;

public class Task_J {
    public static Node insert(Node root, int key) {

        insertRecursively(root, key);
        return root;

    }

    private static Node insertRecursively(Node root, int key) {

        if (root.getLeft() == null && key < root.getValue()) {
            root.setLeft(new Node(null, null, key));
            return root;
        } else if (root.getRight() == null && key >= root.getValue()) {
            root.setRight(new Node(null, null, key));
            return root;
        }

        if (root.getLeft() != null && key < root.getValue()) {
            return insert(root.getLeft(), key);
        } else if (root.getRight() != null && key >= root.getValue()) {
            return insert(root.getRight(), key);
        }

        return null;

    }

    // <template>
    protected static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }
    }
    // <template>
}