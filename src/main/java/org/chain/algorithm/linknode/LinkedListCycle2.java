package org.chain.algorithm.linknode;

/**
 * description:  LinkedListCycleII
 *  输出循环处的node
 * @author Chain
 * @version 1.0
 * @since 2019/12/5 12:51
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode meetingPoint = getMeetingPoint(head);
        if (meetingPoint == null) {
            return null;
        }
        ListNode a = head;
        ListNode b = meetingPoint;
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

    private ListNode getMeetingPoint(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
