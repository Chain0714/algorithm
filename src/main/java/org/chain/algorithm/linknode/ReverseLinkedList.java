package org.chain.algorithm.linknode;
import	java.util.List;

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

        System.out.println(reverse(head));
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
