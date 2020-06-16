package org.chain.daily.no297;

import java.util.*;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * <p>
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append("(0)");
        nodeToList(root, 0, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        String[] split = data.split("\\)");
        for (String s : split) {
            String[] one = s.split("\\(");
            map.put(Integer.valueOf(one[1]), Integer.valueOf(one[0]));
        }
        return buildNode(0, map);
    }

    private TreeNode buildNode(int index, Map<Integer, Integer> map) {
        Integer val = map.get(index);
        if (val == null) {
            return null;
        } else {
            TreeNode curr = new TreeNode(val);
            curr.left = buildNode(index * 2 + 1, map);
            curr.right = buildNode(index * 2 + 2, map);
            return curr;
        }
    }


    private void nodeToList(TreeNode parent, int parentIndex, StringBuilder res) {
        if (null != parent.left) {
            res.append(parent.left.val).append("(").append(parentIndex * 2 + 1).append(")");
            nodeToList(parent.left, parentIndex * 2 + 1, res);
        }
        if (null != parent.right) {
            res.append(parent.right.val).append("(").append(parentIndex * 2 + 2).append(")");
            nodeToList(parent.right, parentIndex * 2 + 2, res);
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        one.left = two;
        one.right = three;
        three.left = four;
        three.right = five;
        Solution solution = new Solution();
        String serialized = solution.serialize(one);
        System.out.println(serialized);
        TreeNode treeNode = solution.deserialize(serialized);
        System.out.println(treeNode);
    }
}
