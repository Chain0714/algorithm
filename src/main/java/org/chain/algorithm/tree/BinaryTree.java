package org.chain.algorithm.tree;

/**
 * 二叉树
 */
public class BinaryTree<T extends Comparable<T>> {
    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    public BinaryTree(T data) {
        this.data = data;
    }

    public BinaryTree(T data, BinaryTree<T> leftChild, BinaryTree<T> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTree<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTree<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTree<T> rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * 插入左节点
     *
     * @param t
     */
    public void insertLeft(T t) {
        BinaryTree<T> node = new BinaryTree<T>(t);
        if (this.leftChild == null) {
            this.leftChild = node;
        } else {
            BinaryTree<T> oldLeftNode = this.leftChild;
            this.leftChild = node;
            node.leftChild = oldLeftNode;
        }
    }

    /**
     * 插入右节点
     *
     * @param t
     */
    public void insertRight(T t) {
        BinaryTree<T> node = new BinaryTree<T>(t);
        if (this.rightChild == null) {
            this.rightChild = node;
        } else {
            BinaryTree<T> oldRightNode = this.rightChild;
            this.rightChild = node;
            node.rightChild = oldRightNode;
        }
    }
}
