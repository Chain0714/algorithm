package org.chain.daily.no84;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 84. 柱状图中最大的矩形
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class Solution {
    /**
     * 暴力解法
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[0] = 0;
        newHeights[len + 1] = 0;
        int l, r;
        for (int i = 1; i < len + 1; i++) {
            if (newHeights[i] == 0) {
                continue;
            }
            l = i - 1;
            r = i + 1;
            while (newHeights[l] >= newHeights[i]) {
                l--;
            }
            while (newHeights[r] >= newHeights[i]) {
                r++;
            }
            ans = Math.max(ans, newHeights[i] * (r - l - 1));
        }
        return ans;
    }

    public int largestRectangleArea2(int[] heights) {
        int ans = 0;
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < newHeights.length; i++) {
            while (newHeights[stack.peek()] > newHeights[i]) {
                Integer curr = stack.pop();
                ans = Math.max(ans, newHeights[curr] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea2(new int[]{2,1,5,6,2,3}));
    }
}
