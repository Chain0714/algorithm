package org.chain.algorithm.linknode;

/**
 * description:  RemoveNthNodeFromEndOfList
 * dummy-1-2-3-4-5-6
 *  给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Chain
 * @version 1.0
 * @since 2019/12/10 11:30
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = dummy;
        int i = 0;
        while (end.next != null) {
            end = end.next;
            if (i == n) {
                start = start.next;
                continue;
            }
            i++;
        }
        if (i < n) {
            return null;
        }
        start.next = start.next.next;
        return dummy.next;
    }
}
