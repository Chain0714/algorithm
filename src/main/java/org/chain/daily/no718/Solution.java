package org.chain.daily.no718;

/**
 * 718. 最长重复子数组
 * <p>
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * <p>
 * 说明:
 * <p>
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //动态规划，可以转换成求A[i:],B[J:]最长公共前缀问题，如果A[i]=B[j].则A[i:],B[J:]=A[i+1:],B[j+1:]+1,否则等于0
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int res = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    //滑动窗口，枚举每一种对齐方式，（A不动，B的首元素和A的每个元素对齐，然后B不动，A的首元素与B的每个元素对齐），求每种对齐方式下的最大连续子串
    public int findLength2(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxlen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxlen);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxlen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxlen);
        }
        return ret;
    }

    public int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }
}
