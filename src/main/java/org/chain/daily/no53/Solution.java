package org.chain.daily.no53;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 动态规划
     * 用f(i)表示以nums[i]结尾的 解，则 f(i)=max(f(i-1)+nums[i],nums[i])
     * 则本题的解为 max(f(0),f(1),...,f(n-1))
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


    /**
     * 分治对于区间A [l,r]，分为L [l,m], R [m+1,r]
     * lSum 表示以左边第一个元素开头的最大和
     * rSum 表示以右边第一个元素结尾的最大和
     * mSum 表示区间内的最大和
     * iSum 表示区间所有和
     * <p>
     * 则：
     * A.iSum = l.iSum + r.iSum;
     * A.lSum = Math.Max(l.lSum, l.iSum + r.lSum);
     * A.rSum = Math.Max(r.rSum, r.iSum + l.rSum);
     * A.mSum = Math.Max(Math.Max(l.mSum, r.mSum), l.rSum + r.lSum);
     * <p>
     * 且当l=i=i时
     * lSum = rSum = mSum = iSum = A[i]
     */
    public int maxSubArray1(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }


    private Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    private Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(iSum, lSum, rSum, mSum);
    }

    @Data
    @AllArgsConstructor
    static class Status {
        int iSum;
        int lSum;
        int rSum;
        int mSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
