package org.chain.daily.no680;

/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * <p>
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * <p>
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abc";
        System.out.println(solution.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        return validate(0, s.length() - 1, s, 1);
    }

    private boolean validate(int low, int high, String s, int times) {
        if (low > high) {
            return true;
        }
        if (s.charAt(low) == s.charAt(high)) {
            return validate(low + 1, high - 1, s, times);
        } else {
            if (times == 0) {
                return false;
            } else {
                return validate(low + 1, high, s, times - 1) || validate(low, high - 1, s, times - 1);
            }
        }
    }

    ////////////////////////////////////

    private boolean validate(int low, int high, String s) {
        while (low < high && s.charAt(low) == s.charAt(high)) {
            low++;
            high--;
        }
        return low >= high;
    }

    public boolean validPalindrome2(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high && s.charAt(low) == s.charAt(high)) {
            low++;
            high--;
        }
        if (low > high) {
            return true;
        } else {
            return validate(low + 1, high, s) || validate(low, high - 1, s);
        }
    }

}
