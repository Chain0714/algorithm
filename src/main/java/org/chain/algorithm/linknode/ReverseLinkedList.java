package org.chain.algorithm.linknode;

import java.util.Stack;

/**
 * description:  Main
 * 链表反转
 *
 * @author Chain
 * @version 1.0
 * @since 2019/11/29 17:36
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i < 6; i++) {
            ListNode node = new ListNode(i);
            curr.next = node;
            curr = node;
        }
        System.out.println(head);

        System.out.println(reverse2(head));
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 利用栈(不推荐！！！)
     *
     * @param head
     * @return
     */
    private static ListNode reverse2(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode r = head;
        while (head != null) {
            head.next = stack.size() > 0 ? stack.pop() : null;
            head = head.next;
        }
        return r;
    }
}
