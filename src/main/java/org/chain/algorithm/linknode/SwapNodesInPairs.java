package org.chain.algorithm.linknode;

/**
 * description:  SwapNodesInPairs
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 1-2-3-4-5
 * 2-1-4-3-5
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author Chain
 * @version 1.0
 * @since 2019/12/5 8:59
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        ListNode a;
        ListNode b;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {
            a = temp.next;
            b = temp.next.next;
            temp.next = b;
            a.next = b.next;
            b.next = a;
            temp = a;
        }
        return pre.next;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode next = swapPairs2(temp.next);
        temp.next = head;
        head.next = next;
        return temp;
    }
}
