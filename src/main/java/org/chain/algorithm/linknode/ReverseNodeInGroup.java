package org.chain.algorithm.linknode;

/**
 * description:  ReverseNodeInKGroup
 * 1-2-3-4-5
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Chain
 * @version 1.0
 * @since 2019/12/5 16:57
 */
public class ReverseNodeInGroup {
    public ListNode reverseGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode breakPoint = head;
        int i = 0;
        while (i < k - 1) {
            if (breakPoint == null || breakPoint.next == null) {
                return head;
            }
            breakPoint = breakPoint.next;
            i++;
        }
        ListNode after = breakPoint.next;
        breakPoint.next = null;
        ListNode result = reverse(head);
        head.next = reverseGroup(after, k);
        return result;
    }

    private ListNode reverse(ListNode head) {
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
}
