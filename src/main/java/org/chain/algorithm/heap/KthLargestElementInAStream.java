package org.chain.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author renchen
 * @date 2019-12-10 21:03
 **/
public class KthLargestElementInAStream {

    private PriorityQueue<Integer> queue;

    private int size;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.queue = new PriorityQueue<>(k);
        this.size = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (this.queue.size() < size) {
            this.queue.offer(val);
        } else if (val > this.queue.peek()) {
            this.queue.offer(val);
            this.queue.poll();
        }
        return this.queue.peek();
    }


}
