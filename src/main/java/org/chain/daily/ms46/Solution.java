package org.chain.daily.ms46;

/**
 * 面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class Solution {
    /**
     * 动态规划 用f(i)表示以第i个位数字结尾的答案，x表示第i位和i-1位组成的数字，则 f(i)=f(i-1)+f(i-2)[i≥1,10≤x≤25] f(−1)=0，f(0)=1
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < str.length(); i++) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String seq = str.substring(i - 1, i + 1);
            if (seq.compareTo("10") >= 0 && seq.compareTo("25") <= 0) {
                r += p;
            }
        }
        return r;
    }

    /**
     * 递归
     */
    public int translateNum2(int num) {
        String src = String.valueOf(num);
        return fun(src, 0, new int[src.length()]);
    }

    /**
     * 返回从pointer位置到字符串结尾的翻译方法数
     *
     * @param str
     * @param pointer
     * @param storage
     * @return
     */
    private int fun(String str, int pointer, int[] storage) {
        if (pointer >= str.length() - 1) {
            return 1;
        }
        if (storage[pointer] > 0) {
            return storage[pointer];
        }
        String seq = str.substring(pointer, pointer + 2);
        if (seq.compareTo("10") >= 0 && seq.compareTo("25") <= 0) {
            storage[pointer] = fun(str, pointer + 1, storage) + fun(str, pointer + 2, storage);
        } else {
            storage[pointer] = fun(str, pointer + 1, storage);
        }
        return storage[pointer];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum2(25));
    }


}
