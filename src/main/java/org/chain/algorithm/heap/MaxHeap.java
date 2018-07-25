package org.chain.algorithm.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 最大堆，用作优先队列的TOPK查找<br>
 * 原理：每个节点的值都>=其左右孩子（如果有的话）值的完全二叉树
 *
 * @param <T>
 * @author Anthony
 */
public class MaxHeap<T extends Comparable<T>> {

    /**
     * 堆数据
     */
    private List<T> heap;

    public MaxHeap(List<T> heap) {
        this.heap = heap;
    }


    /**
     * 向最大堆中插入元素，添加到数组的尾部，然后上升操作
     *
     * @param value
     */
    public void insert(T value) {
        // 数组下标为0的位置不放元素
        if (heap.size() == 0)
            heap.add(null);
        heap.add(value);
        up(heap.size() - 1);
    }

    /**
     * 节点上升递归实现<br>
     * 由于新插入的数是在数组尾部，所以需要做上升操作，让插入的数和父节点的值比较，当大于父节点的时候交换
     *
     * @param index
     */
    private void up(int index) {
        // 注意堆是从下标为1开始，当index=1的时候，已经是根节点了
        if (index <= 1)
            return;

        int parent = index / 2; // 父节点
        T parentValue = heap.get(parent);
        T indexValue = heap.get(index);
        if (parentValue.compareTo(indexValue) < 0) {
            swap(parent, index);
            up(parent);
        }
    }

    /**
     * 节点上升非递归实现
     *
     * @param index
     */
    @SuppressWarnings("unused")
    private void up2(int index) {
        int parent = 0;
        for (; index > 1; index /= 2) {
            parent = index / 2;
            T parentValue = heap.get(parent);
            T indexValue = heap.get(index);
            if (parentValue.compareTo(indexValue) < 0)
                swap(parent, index);
        }
    }

    /**
     * 交换a和b的位置
     *
     * @param a
     * @param b
     */
    private void swap(int a, int b) {
        T temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    /**
     * 删除堆中位置是index处的值<br>
     * 原理是：当删除节点时，原来的位置就会出现一个孔，填充这个孔的方法就是，把最后的叶子赋给该孔，然后把该叶子删除
     *
     * @param index
     */
    public void delete(int index) {
        heap.set(index, heap.get(heap.size() - 1));
        down(index);
        heap.remove(heap.size() - 1);
    }

    /**
     * 节点下沉递归实现<br>
     * 删除数据的时候，由于是用的尾部的数据（基本上是最小值）填充，所以需要做下沉操作
     *
     * @param index
     */
    public void down(int index) {
        int n = heap.size() - 2; // 因为最后一个节点已经挪至index位置，所以已经是废弃叶子节点，不再考虑
        int child = 2 * index;

        // 说明该节点没有左右儿子节点了，那么无须下沉，直接返回
        if (child > n)
            return;

        // 如果左右儿子都存在，取值较大的那个儿子节点
        if (child < n
                && heap.get(child).compareTo(heap.get(child + 1)) < 0)
            child++;

        // 如果该节点小于较大的那个儿子，那么下沉
        if (heap.get(index).compareTo(heap.get(child)) < 0) {
            swap(child, index);
            down(child);
        }
    }

    /**
     * 节点下沉非递归实现
     *
     * @param index
     */
    public void down2(int index) {
        T temp = heap.get(index);
        int n = heap.size() - 2;
        int child = 0;
        for (; 2 * index <= n; index = child) {
            child = 2 * index;
            if (child < n
                    && heap.get(child).compareTo(heap.get(child + 1)) < 0)
                child++;
            if (temp.compareTo(heap.get(child)) < 0)
                swap(child, index);
            else
                break;
        }
    }

    /**
     * 根据树的性质建堆，树节点前一半一定是分支节点，即有孩子的，所以我们从这里开始调整出初始堆
     */
    public void adjust() {
        for (int i = heap.size() / 2; i > 0; i--)
            adjust(i, heap.size() - 1);
    }

    /**
     * 调整堆，使其满足最大堆得定义<br>
     * 具体调整过程为: 从最后一个分支结点（n/2）开始，到根（1）为止，依次对每个分支结点进行调整（下沉）<br>
     * 以便形成以每个分支结点为根的堆，当最后对树根结点进行调整后，整个树就变成了一个堆
     *
     * @param i
     * @param n
     */
    public void adjust(int i, int n) {
        int child = 0;
        for (; i <= n / 2; ) {
            child = i * 2;
            if (child < n
                    && heap.get(child).compareTo(heap.get(child + 1)) < 0)
                child++;
            if (heap.get(i).compareTo(heap.get(child)) < 0) {
                swap(i, child);
                i = child; // 交换后，以child+1为根的子树不一定满足堆定义，所以从child处开始调整
            } else
                break;
        }
    }

    /**
     * 堆排序，从尾部开始，将每个节点和根节点交换，然后调整节点之上的子堆
     */
    public void sort() {
        for (int i = heap.size() - 1; i > 0; i--) {
            swap(1, i);
            adjust(1, i - 1);
        }
    }

    public static void main(String args[]) {
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(null, 1, 2,
                5, 10, 3, 7, 11, 15, 17, 20, 9, 15, 8, 16));
        MaxHeap<Integer> mh = new MaxHeap<Integer>(array);
        mh.adjust();
        System.out.println("调整后的初始堆:" + array);
        mh.delete(8);
        System.out.println("删除下标8之后的堆:" + array);
        mh.insert(99);
        System.out.println("添加值99之后的堆:" + array);
        mh.sort();
        System.out.println("排序后的堆:" + array);
    }
}