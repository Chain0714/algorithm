package org.chain.daily.no974;


/**
 * 974. 和可被 K 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int subarraysDivByK(int[] A, int K) {
        if (null == A || A.length == 0 || K == 0) {
            return 0;
        }
        int[] pos = new int[K];
        pos[0] = 1;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int rem = ((sum % K) + K) % K;
            res += pos[rem];
            pos[rem]++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{7, -5, 5, -8, -6, 6, -4, 7, -8, -7};
        System.out.println(solution.subarraysDivByK(A, 7));
    }
}
