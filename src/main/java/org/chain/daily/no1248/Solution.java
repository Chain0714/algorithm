package org.chain.daily.no1248;


/**
 * 1248. 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中「优美子数组」的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */
public class Solution {
    /**
     *我的答案，已提交通过
     * 思路：前缀法，遍历目标数组，用pos[]记录出现x次奇数的位置数，x作为pos[]的下标，注意，pos[0]初始值为1，因为遍历目标数组开始之前，就是出现奇数次数为0的位置，
     * 当遍历到底i个数字时候，目前出现奇数累积次数为n，则只要计算出（n-k）次奇数出现的位置数，即pos[n-k],即为优美子数组出现的次数
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int[] pos = new int[nums.length + 1];
        pos[0] = 1;
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                count++;
            }
            pos[count]++;
            if (count - k >= 0) {
                res += pos[count - k];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int k = 1;
        System.out.println(solution.numberOfSubarrays(nums, k));
    }
}
