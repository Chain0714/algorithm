package org.chain.algorithm.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * description:  Subsets
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Chain
 * @version 1.0
 * @since 2019/12/16 17:37
 */
public class Subsets {
    //    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        int bit = 1 << nums.length;
//        for (int i = 0; i < bit; i++) {
//            int var = i;
//            List<Integer> temp = new ArrayList<>();
//            for (int num : nums) {
//                if ((var & 1) == 1) {
//                    temp.add(num);
//                }
//                var = var >> 1;
//            }
//            result.add(temp);
//        }
//        return result;
//    }
    private List<List<Integer>> res;

    private void find(int[] nums, int begin, List<Integer> pre) {
        // 没有显式的递归终止
        // 注意：Java 的引用传递机制，这里要 new 一下
        res.add(new ArrayList<>(pre));
        for (int i = begin; i < nums.length; i++) {
            pre.add(nums[i]);
            find(nums, i + 1, pre);
            // 组合问题，状态在递归完成后要重置
            pre.remove(pre.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        List<Integer> pre = new ArrayList<>();
        find(nums, 0, pre);
        return res;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsets.subsets(nums);
        for (List<Integer> list : result) {
            System.out.print("[");
            for (Integer i : list) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println("]");
        }
    }
}
