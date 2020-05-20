package org.chain.daily.no1371;


import java.util.Arrays;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 * <p>
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "leetcodeisgreat"
 * 输出：5
 * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "bcbcbc"
 * 输出：6
 * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 5 x 10^5
 * s 只包含小写英文字母。
 */
public class Solution {

    /**
     * 5个元音字母的奇偶组合一共32种可能，即2^5,用一个长度为32的数组pos[]记录每种组合出现的最早位置，遍历字符串
     * 设当前位置位置是r，对应的奇偶性组合为a，则当前位置符合条件的字串范围是[pos[a]+1,r],长度为r-pos[a]
     * 取最大值即可
     */
    public int findTheLongestSubstring(String s) {
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        //0表示出现偶数次
        int status = 0b00000;
        int ans = 0;
        //首字符pos从1开始，因为0要留给空字符串，即所有元音字母都出现0次，否则，假如第一个字符是非元音，则计算长度的时候会把首字符排除在外导致少算一个字符
        pos[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //与1亦或相当于取反，即如果前一个位置字符a的奇偶性是x，如果当前位置字符是a，则当前a的奇偶性是~x
            if (ch == 'a') {
                status ^= 1;
            } else if (ch == 'e') {
                status ^= 1 << 1;
            } else if (ch == 'i') {
                status ^= 1 << 2;
            } else if (ch == 'o') {
                status ^= 1 << 3;
            } else if (ch == 'u') {
                status ^= 1 << 4;
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheLongestSubstring("eleetminicoworoep"));
    }

}
