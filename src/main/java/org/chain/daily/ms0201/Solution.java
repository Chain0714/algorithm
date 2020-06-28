package org.chain.daily.ms0201;

import org.chain.algorithm.linknode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        while (head.next != null) {
            if (set.contains(head.next.val)) {
                {
                    head.next = head.next.next;
                }
            } else {
                set.add(head.next.val);
            }
        }
        return head;
    }
}
