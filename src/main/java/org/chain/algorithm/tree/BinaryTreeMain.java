package org.chain.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = initIntegerBinaryTree();
        System.out.println("******广度优先遍历，期望结果：0123456******");
        bfsOrder(tree);
        System.out.println("/");
        System.out.println("******前序遍历，期望结果：0134256******");
        preDfsOrder(tree);
        System.out.println("/");
        System.out.println("******中序遍历，期望结果：3140526******");
        midDfsOrder(tree);
        System.out.println("/");
        System.out.println("******后序遍历，期望结果：3415620******");
        postDfsOrder(tree);
        System.out.println("/");
        System.out.println("******初始化二叉搜索树******");
        BinaryTree<Integer> binarySearchTree = initBinarySearchTree();
        System.out.println("******使用广度优先遍历，预期输出结果50，21，76，4，32，64，100，52******");
        System.out.println("/");
        bfsOrder(binarySearchTree);
        System.out.println("******在二叉搜索树中搜索存在的值，52，预期输出：true");
        System.out.println(binarySearch(binarySearchTree, 52));
        System.out.println("******在二叉搜索树中搜索存在的值，53，预期输出：false");
        System.out.println(binarySearch(binarySearchTree, 53));
    }

    /**
     * 前序遍历
     *
     * @param tree
     * @param <T>
     */
    private static <T extends Comparable<T>> void preDfsOrder(BinaryTree<T> tree) {
        System.out.print(tree.getData());
        if (tree.getLeftChild() != null) {
            preDfsOrder(tree.getLeftChild());
        }
        if (tree.getRightChild() != null) {
            preDfsOrder(tree.getRightChild());
        }
    }

    /**
     * 中序遍历
     *
     * @param tree
     * @param <T>
     */
    private static <T extends Comparable<T>> void midDfsOrder(BinaryTree<T> tree) {
        if (tree.getLeftChild() != null) {
            midDfsOrder(tree.getLeftChild());
        }
        System.out.print(tree.getData());
        if (tree.getRightChild() != null) {
            midDfsOrder(tree.getRightChild());
        }
    }

    /**
     * 后序遍历
     *
     * @param tree
     * @param <T>
     */
    private static <T extends Comparable<T>> void postDfsOrder(BinaryTree<T> tree) {
        if (tree.getLeftChild() != null) {
            postDfsOrder(tree.getLeftChild());
        }
        if (tree.getRightChild() != null) {
            postDfsOrder(tree.getRightChild());
        }
        System.out.print(tree.getData());
    }


    /**
     * 广度优先遍历
     *
     * @param tree
     * @param <T>
     */
    private static <T extends Comparable<T>> void bfsOrder(BinaryTree<T> tree) {
        if (null == tree) {
            return;
        }
        Queue<BinaryTree<T>> queue = new ArrayDeque<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            BinaryTree<T> currNode = queue.poll();
            System.out.print(currNode.getData());
            if (currNode.getLeftChild() != null) {
                queue.add(currNode.getLeftChild());
            }
            if (currNode.getRightChild() != null) {
                queue.add(currNode.getRightChild());
            }
        }
    }

    /**
     * 0
     * 1         2
     * 3    4    5    6
     *
     * @return
     */
    private static BinaryTree<Integer> initIntegerBinaryTree() {
        BinaryTree<Integer> rootNode = new BinaryTree<>(0);
        rootNode.insertLeft(1);
        rootNode.insertRight(2);
        rootNode.getLeftChild().insertLeft(3);
        rootNode.getLeftChild().insertRight(4);
        rootNode.getRightChild().insertLeft(5);
        rootNode.getRightChild().insertRight(6);
        return rootNode;
    }

    /**
     * 初始化二叉搜索树
     *
     * @return
     */
    private static BinaryTree<Integer> initBinarySearchTree() {
        BinaryTree<Integer> binarySearchTree = new BinaryTree<>(50);
        insertToBinarySearchTree(binarySearchTree, 76);
        insertToBinarySearchTree(binarySearchTree, 21);
        insertToBinarySearchTree(binarySearchTree, 4);
        insertToBinarySearchTree(binarySearchTree, 32);
        insertToBinarySearchTree(binarySearchTree, 100);
        insertToBinarySearchTree(binarySearchTree, 64);
        insertToBinarySearchTree(binarySearchTree, 52);
        return binarySearchTree;
    }

    /**
     * 插入二叉搜索树
     *
     * @param rootNode 根节点
     * @param data
     * @param <T>
     */
    private static <T extends Comparable<T>> void insertToBinarySearchTree(BinaryTree<T> rootNode, T data) {
        if (null == rootNode) {
            return;
        }
        if (data.compareTo(rootNode.getData()) <= 0) {
            if (rootNode.getLeftChild() == null) {
                rootNode.setLeftChild(new BinaryTree<>(data));
            } else {
                insertToBinarySearchTree(rootNode.getLeftChild(), data);
            }
        }
        if (data.compareTo(rootNode.getData()) > 0) {
            if (rootNode.getRightChild() == null) {
                rootNode.setRightChild(new BinaryTree<>(data));
            } else {
                insertToBinarySearchTree(rootNode.getRightChild(), data);
            }
        }

    }

    /**
     * 判断目标是否存在二叉搜索树中
     *
     * @param binarySearchTree
     * @param target
     * @param <T>
     * @return
     */
    private static <T extends Comparable<T>> boolean binarySearch(BinaryTree<T> binarySearchTree, T target) {
        if (binarySearchTree == null) {
            return false;
        }
        T currData = binarySearchTree.getData();
        if (currData.compareTo(target) > 0) {
            return binarySearch(binarySearchTree.getLeftChild(), target);
        }
        if (currData.compareTo(target) < 0) {
            return binarySearch(binarySearchTree.getRightChild(), target);
        }
        return currData.compareTo(target) == 0;
    }
}
