package com.minos.datastructure.heap.maxheap;

import com.minos.datastructure.linearstructure.array.Array;

/**
 * 用数组存储二叉堆
 *
 * @Author: minos
 * @Date: 2020/10/27 22:28
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * heapify 将任意数组转换为堆
     * 直接实现成一个构造函数
     *
     * @param arr
     */
    public MaxHeap(E[] arr) {

        data = new Array<>(arr);
        // parent(arr.length - 1) 得到最后一个非叶子节点的索引
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 返回堆中的元素个数
     *
     * @return
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 返回布尔值，堆中是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父节点的索引
     *
     * @param index
     * @return 父节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");

        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素e
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        // data.getSize() - 1 得到新加入元素的索引
        siftUp(data.getSize() - 1);
    }

    /**
     * 如果新添加元素较大， 使其"上浮"。如果是最大，会上浮到根节点
     *
     * @param k
     */
    private void siftUp(int k) {

        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 找出堆中最大元素
     *
     * @return
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 取出(删除)堆中最大的元素
     * 1.把最小的一个元素的值放到根堆的根节点处，并把该节点删除
     * 2.把最小元素下沉
     *
     * @return
     */
    public E extractMax() {

        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();

        // 调用siftDown()维护最大堆的性质
        siftDown(0);

        return ret;
    }

    /**
     * 下沉过程：
     * 1.根节点和左右孩子比较
     * 2.和左右孩子中值较大者交换
     * 3.如此往复
     *
     * @param k 需下沉节点的索引
     */
    private void siftDown(int k) {

        // 如果左孩子的索引都大于等于整个size了说明索引肯定越界了
        while (leftChild(k) < data.getSize()) {

            // j用来存左右孩子中值最大的那一个节点的索引
            // 只要进到循环，说明此事的节点一定有左孩子
            int j = leftChild(k);
            // j + 1 < data.getSize() 此事不一定有有孩子所以要进行判断
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                // 如果右孩子的值较大，那么j的值为右孩子的索引
                // 相当于j++
                j = rightChild(k);
            }

            //如果当前节点的值比左右孩子的值大，退出循环
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            //没退出循环表示当前节点的值比左右孩子中最大值小, 进行值的交换
            data.swap(k, j);

            //交换完成后，当前节点跟着值移动，然后继续循环
            k = j;
        }
    }

    /**
     * 取出堆中的最大元素，并且替换成元素e
     * 实现：直接把元素放到0索引处， 然后siftDown
     *
     * @param e
     * @return
     */
    public E replace(E e) {

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


}
