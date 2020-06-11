package org.chain.daily.no42;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 如图，数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）
 */
public class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int preIndex = stack.pop();
                Integer prePreTop = stack.peek();
                if (null == prePreTop) {
                    break;
                }
                ans += (i - stack.peek()-1) * (Math.min(height[i], height[stack.peek()]) - height[preIndex]);
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
