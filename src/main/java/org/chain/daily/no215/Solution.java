package org.chain.daily.no215;

import java.util.*;

/**
 * 215. 数组中的第K个最大元素
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int size = 0;
        for (int i : nums) {
            if (size < k) {
                queue.offer(i);
                size++;
            } else {
                if (queue.peek() < i) {
                    queue.poll();
                    queue.offer(i);
                }
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.merge(3, 40, (o1, o2) -> o1 - o2);
        System.out.println(map.get(3));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
