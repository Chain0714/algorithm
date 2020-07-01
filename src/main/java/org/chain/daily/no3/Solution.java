package org.chain.daily.no3;

import java.util.*;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //动态规划，最长不重复字串必然是以第i个字符结尾，只需要比较第i-1个字符结尾的最长不重复字串的长度和i减去第i个字符上次出现的位置即可
    public int lengthOfLongestSubstring(String s) {
        int preLen = 0;
        int max = 0;
        Map<String, Integer> pos = new HashMap<>();
        for (int i = 1; i <= s.length(); i++) {
            String curr = String.valueOf(s.charAt(i - 1));
            Integer lastPos = pos.getOrDefault(curr, 0);
            if (i - lastPos > preLen) {
                preLen++;
            } else {
                preLen = i - lastPos;
            }
            max = Math.max(max, preLen);
            pos.put(curr, i);
        }
        return max;
    }

    //双指针
    public int lengthOfLongestSubstring2(String s) {
        Map<String, Integer> pos = new HashMap<>();
        int res = 0;
        int i = 0, j = 1;
        while (j <= s.length()) {
            String curr = String.valueOf(s.charAt(j - 1));
            if (pos.getOrDefault(curr, 0) > i) {
                i = pos.getOrDefault(curr, 0);
            }
            pos.put(curr, j);
            res = Math.max(res, j - i);
            j++;
        }
        return res;
    }

    //队列
    public int lengthOfLongestSubstring3(String s) {
        Deque<Character> queue = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            while (queue.contains(s.charAt(i))) {
                queue.removeFirst();
            }
            queue.addLast(s.charAt(i));
            res = Math.max(res, queue.size());
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring3(""));
    }
}
