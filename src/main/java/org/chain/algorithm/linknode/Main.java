package org.chain.algorithm.linknode;

/**
 * description:  Main
 * 链表反转
 *
 * @author Chain
 * @version 1.0
 * @since 2019/11/29 17:36
 */
public class Main {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node curr = head;
        for (int i = 2; i < 6; i++) {
            Node node = new Node(i);
            curr.next = node;
            curr = node;
        }
        System.out.println(head);

        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        System.out.println(pre);
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
