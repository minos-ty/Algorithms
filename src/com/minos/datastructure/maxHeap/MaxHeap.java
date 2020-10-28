package com.minos.datastructure.maxHeap;

import com.minos.datastructure.array.Array;

/**
 * E extends Comparable<E> 让传入的元素E必须具有比较性
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
     * 将数组转换为堆 heapify
     * @param arr
     */
    public MaxHeap(E[] arr) {

        data = new Array<>(arr);
        // parent(arr.length - 1) 得到最后一个非叶子节点的索引
        for (int i = parent(arr.length - 1); i >= 0; i-- ) {
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
     * @return
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
     * @return
     */
    public E extractMax() {

        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {

        while (leftChild(k) < data.getSize()) {

            // j用来存左右孩子中值最大的那一个节点的索引
            int j = leftChild(k);
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }

            //如果当前节点的值比左右孩子的值大，退出循环
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            //没退出循环表示当前节点的值比左右孩子中最大值小, 进行值得交换
            data.swap(k, j);

            //交换完成后，当前节点跟着值移动，然后继续循环
            k = j;
        }
    }

    /**
     * 取出堆中的最大元素，并且替换成元素e
     * 实现：直接把元素放到0索引处， 然后siftDown
     * @param e
     * @return
     */
    public E replace(E e){

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


}
