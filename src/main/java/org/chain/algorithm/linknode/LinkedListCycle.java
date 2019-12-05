package org.chain.algorithm.linknode;

import java.util.HashSet;
import java.util.Set;

/**
 * description:  LinkedListCycle
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Chain
 * @version 1.0
 * @since 2019/12/5 11:06
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        return check(set, head);
    }

    private boolean check(Set<ListNode> set, ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        if (set.contains(head.next)) {
            return true;
        }
        set.add(head);
        return check(set, head.next);
    }

    public boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
