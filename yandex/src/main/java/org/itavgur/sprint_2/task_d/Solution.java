// <template>
/*
class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}
// <template>

public class Solution {
    public static int solution(Node<String> head, String elem) {

        int idx = 0;
        boolean found = false;

        while (head.next != null) {
            if (elem.equals(head.value)) {
                found = true;
                break;
            }
            head = head.next;
            idx++;
        }
        return found ? idx : -1;
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        int idx = solution(node0, "node2");
        assert idx == 2;
    }
}
 */