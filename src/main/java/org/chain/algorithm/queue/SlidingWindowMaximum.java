package org.chain.algorithm.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * description:  SlidingWindowMaximum
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Chain
 * @version 1.0
 * @since 2019/12/11 19:29
 */
public class SlidingWindowMaximum {
    private Deque<Integer> dq = new ArrayDeque<>();
    private int[] nums;
    private int k;

    /**
     * 双端队列
     * 当nums大是效率不佳
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        if (k * nums.length == 0) {
            return new int[0];
        }
        this.k = k;
        this.nums = nums;
        int[] result = nums.length <= k ? new int[1] : new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                result[0] = fix(i);
            } else {
                result[i - k + 1] = fix(i);
            }
        }
        return result;
    }

    private int fix(int i) {
        if (this.dq.isEmpty()) {
            this.dq.addLast(i);
            return this.nums[i];
        }
        if (this.dq.getFirst() <= i - this.k) {
            this.dq.removeFirst();
        }
        while (!this.dq.isEmpty() && nums[i] > nums[this.dq.getLast()]) {
            this.dq.removeLast();
        }
        this.dq.addLast(i);
        return this.nums[this.dq.getFirst()];
    }

    /**
     * 动态规划
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int i, j;
        int[] maxes = new int[nums.length - k + 1];
        for (i = 0; i < nums.length - k + 1; i++) {
            j = i + k - 1;
            int maxPos = -1;
            maxes[i] = Math.max(maxNum(nums, maxPos, i, (i / k) * k + (k - 1)), maxNum(nums, maxPos, (j / k) * k, j));
        }
        return maxes;
    }

    private int maxNum(int[] nums, int maxPos, int start, int end) {
        if (maxPos != -1 && nums[end] >= nums[maxPos]) {
            maxPos = end;
            return nums[end];
        } else if (start <= maxPos) {
            return nums[maxPos];
        } else {
            int maxVal = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                if (nums[i] > maxVal) {
                    maxVal = nums[i];
                    maxPos = i;
                }
            }
            return nums[maxPos];
        }
    }

    /**
     * 最优
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] maxes = new int[nums.length - k + 1];
        int i, j;
        int maxPos = -1;
        for (i = 0; i <= nums.length - k; ++i) {
            // Ending index of the current window
            j = i + k - 1;
            // new element >= max of last window
            // that means new element is max in the two windows
            // here using >= to make maxPos stay in the windows for a longer time
            if (maxPos != -1 && nums[j] >= nums[maxPos]) {
                maxPos = j;
                maxes[i] = nums[maxPos];
                // new element < max of last window
                // AND the max of last window is also in this window
                // => it means the max of the last window is still the max of this window
            } else if (i <= maxPos) {
                maxes[i] = nums[maxPos];
                // new element < max of last window
                // AND the max of last window is not in this window
                // So we do not know which element is the max in this window, we have to scan the window to find it
            } else {
                int maxWindow = Integer.MIN_VALUE;
                int maxPosWindow = 0;
                for (int z = i; z <= j; ++z) {
                    if (nums[z] > maxWindow) {
                        maxPosWindow = z;
                        maxWindow = nums[z];
                    }
                }
                maxPos = maxPosWindow;
                maxes[i] = nums[maxPos];
            }
        }
        return maxes;
    }

    /**
     * 题解动态规划
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) {
                // block_start
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) {
                // block_end
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }

        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            output[i] = Math.max(left[i + k - 1], right[i]);
        }

        return output;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
//        int size = 10000000;
//        int k = 1000;
//        int[] nums = new int[size];
//        Random r = new Random();
//        for (int i = 0; i < size; i++) {
//            nums[i] = r.nextInt();
//        }
//
//        StopWatch sw = new StopWatch();
//        sw.start();
//        slidingWindowMaximum.maxSlidingWindow(nums, k);
//        sw.stop();
//        System.out.println(sw.getTime());
//        sw.reset();
//
//        sw.start();
//        slidingWindowMaximum.maxSlidingWindow3(nums, k);
//        sw.stop();
//        System.out.println(sw.getTime());
//        sw.reset();
//
//        sw.start();
//        slidingWindowMaximum.maxSlidingWindow2(nums, k);
//        sw.stop();
//        System.out.println(sw.getTime());
//        sw.reset();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = slidingWindowMaximum.maxSlidingWindow1(nums, 3);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
