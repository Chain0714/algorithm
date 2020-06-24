package org.chain.daily.no16;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int tempAbs = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int b = i + 1;
            int c = nums.length - 1;
            while (c > b) {
                int temp = nums[i] + nums[b] + nums[c];
                if (Math.abs(temp - target) < tempAbs) {
                    tempAbs = Math.abs(temp - target);
                    res = temp;
                }
                if (temp > target) {
                    c--;
                } else if (temp < target) {
                    b++;
                } else {
                    return temp;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1,2,1,-4},1));
    }
}
