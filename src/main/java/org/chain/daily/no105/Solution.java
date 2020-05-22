package org.chain.daily.no105;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * <p>
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 3 9 20 15 7
 * 9 3 15 20 7
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     * 前序：[root,[左子树前序],[右子树前序]]
     * [3,     9,       20,15,7]
     * 中序：[[左子树中序],root,[右子树中序]]
     * [9,        3,   15,20,7]
     */
    public TreeNode buildTree(int[] preorder, int[] inorder, int fl, int fr, int ml, int mr) {
        int rootVal = preorder[fl];
        TreeNode root = new TreeNode(rootVal);
        int i = 0;
        for (; ml + i <= mr; i++) {
            if (inorder[ml + i] == rootVal) {
                break;
            }
        }
        if (i > 0) {
            root.left = buildTree(preorder, inorder, fl + 1, fl + i, ml, ml + i - 1);
        }
        if (ml + i < mr) {
            root.right = buildTree(preorder, inorder, fl + 1 + i, fr, ml + i + 1, mr);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {1};
        int[] inorder = {1};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        System.out.println(111);
    }

}
