package org.itavgur.sprint_2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

// <template>
class Node<V> {
    public V value;
    public Node<V> next;
    public Node<V> prev;

    public Node(V value, Node<V> next, Node<V> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
// <template>

public class Solution {
    public static Node<String> solution(Node<String> head) {

        while (true) {

            Node<String> tmp = head.next;
            head.next = head.prev;
            head.prev = tmp;

            if (head.prev == null) return head;
            head = head.prev;

        }



    }


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap();
        int[] res = new int[2];
        for(int i = 0; i<nums.length;i++){
            map.put(nums[i], i);
        }


        for(int i = 0; i<nums.length;i++){

            Integer idx = map.get(target - nums[i]);
            System.out.println(idx);

            if(idx != null && idx != i){
                res[0] = i;
                res[1] = idx;
                break;
            }

            return res;


        }




        return res;
    }
    @Test
    public void test() {
        Node<String> node3 = new Node<>("node3", null, null);
        Node<String> node2 = new Node<>("node2", node3, null);
        Node<String> node1 = new Node<>("node1", node2, null);
        Node<String> node0 = new Node<>("node0", node1, null);
        node1.prev = node0;
        node2.prev = node1;
        node3.prev = node2;
        Node<String> newNode = solution(node0);
        /* result is :*/
        assert newNode == node3;
        assert node3.next == node2;
        assert node2.next == node1;
        assert node2.prev == node3;
        assert node1.next == node0;
        assert node1.prev == node2;
        assert node0.prev == node1;
    }
}