package org.chain.daily.no160;

import org.chain.algorithm.linknode.ListNode;

/**
 * 160. 相交链表
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            if (pA != null) {
                pA = pA.next;
            } else {
                pA = headB;
            }
            if (pB != null) {
                pB = pB.next;
            } else {
                pB = headA;
            }
        }
        return pA;
    }
}
