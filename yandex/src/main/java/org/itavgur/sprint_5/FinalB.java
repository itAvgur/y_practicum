package org.itavgur.sprint_5;

/*
30 ноя 2023, 14:41:13
100505203

-- ПРИНЦИП РАБОТЫ --

Используется дополнительный класс Nodes для сохранения информации о найденном узле, родителе, новом узле и его родителе

1) ищем рекурсивно целевой узел, возвращает его + его родителя (т.е. работает с односвязным списком)
2) если не нашли - завершаем
3) пробуем рекурсивно найти самого правого родителя слева, если не нашли, то самого левого родителя справа
4) если не нашли, то просто берем самого первого предка слева/справа
5) обогащаем Nodes найденной информацией
6) если ничего не нашли, значит этот целевой узел = лист
7) удаляем новый узел (меняем ссылки у родителя и предков)
8) добавляем его на место целевого узла (также меняем ссылки)
9) если корень дерева изменился, то отдаем новый узел. если нет - то отдаем старый корень дерева

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --

Стандартный алгоритм удаления согласно описания


-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Используется несколько рекурсивных проходов, поиск целевого узла (выбираем идти влево или вправо в зависимости от ключа и значения узла),
поиск нового узла, который его заменит (ищем в том же поддереве)

Итоговая сложность O(H)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Исходное дерево + instance класса Nodes.
Никаких дополнительных структур не используем

Итого O(n)

*/

public class FinalB {
    public static Node remove(Node root, int key) {

        Nodes nodes = findTargetNodeRecursively(root, key, null);

        if (nodes == null) return root;

        Node target = nodes.target;

        if (target.getLeft() != null) {
            Nodes mostRightNode = findRightNodesRecursively(target.getLeft());
            if (mostRightNode == null) {
                nodes.newNode = target.getLeft();
                nodes.parentOfNewNode = target;
            } else {
                nodes.newNode = mostRightNode.target;
                nodes.parentOfNewNode = mostRightNode.parent;
            }

        } else if (target.getRight() != null) {
            Nodes mostLeftNode = findLeftNodesRecursively(target.getRight());
            if (mostLeftNode == null) {
                nodes.newNode = target.getRight();
                nodes.parentOfNewNode = target;
            } else {
                nodes.newNode = mostLeftNode.target;
                nodes.parentOfNewNode = mostLeftNode.parent;
            }

        }
        replaceNodes(nodes);

        return root == nodes.target ? nodes.newNode : root;
    }

    private static Nodes findRightNodesRecursively(Node node) {

        if (node.getRight() != null) {
            Nodes rightNode = findRightNodesRecursively(node.getRight());
            return rightNode == null ? new Nodes(node.getRight(), node) : rightNode;

        } else if (node.getLeft() != null) {
            return findRightNodesRecursively(node.getLeft());
        }
        return null;
    }

    private static Nodes findLeftNodesRecursively(Node node) {

        if (node.getLeft() != null) {
            Nodes leftNode = findLeftNodesRecursively(node.getLeft());
            return leftNode == null ? new Nodes(node.getLeft(), node) : leftNode;

        } else if (node.getRight() != null) {
            return findLeftNodesRecursively(node.getRight());
        }
        return null;
    }

    private static Nodes findTargetNodeRecursively(Node node, int key, Node parent) {

        if (node == null) return null;
        if (node.getValue() == key) return new Nodes(node, parent);

        Nodes found = null;

        if (key < node.getValue()) {
            found = findTargetNodeRecursively(node.getLeft(), key, node);
            if (found == null) {
                found = findTargetNodeRecursively(node.getRight(), key, node);
            }
        }
        if (key > node.getValue()) {
            found = findTargetNodeRecursively(node.getRight(), key, node);
            if (found == null) {
                found = findTargetNodeRecursively(node.getLeft(), key, node);
            }
        }

        return found;
    }

    private static void replaceNodes(Nodes nodes) {

        if (nodes.newNode != null) {

            Node childOfNewNode;
            if (nodes.newNode.getLeft() != null) {
                childOfNewNode = nodes.newNode.getLeft();
            } else {
                childOfNewNode = nodes.newNode.getRight();
            }

            if (nodes.parentOfNewNode.getLeft() != null && nodes.parentOfNewNode.getLeft().getValue() == nodes.newNode.getValue()) {
                nodes.parentOfNewNode.setLeft(childOfNewNode);
            } else {
                nodes.parentOfNewNode.setRight(childOfNewNode);
            }

            nodes.newNode.setLeft(nodes.target.getLeft());
            nodes.newNode.setRight(nodes.target.getRight());
        }

        if (nodes.parent != null && nodes.parent.getLeft() != null && nodes.parent.getLeft().getValue() == nodes.target.getValue()) {
            nodes.parent.setLeft(nodes.newNode);
        } else if (nodes.parent != null && nodes.parent.getRight() != null && nodes.parent.getRight().getValue() == nodes.target.getValue()) {
            nodes.parent.setRight(nodes.newNode);
        }
    }

    private static class Nodes {
        private final Node target;
        private final Node parent;
        private Node newNode;
        private Node parentOfNewNode;

        private Nodes(Node target, Node parent) {
            this.target = target;
            this.parent = parent;
        }

    }

    static class Node {
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
}