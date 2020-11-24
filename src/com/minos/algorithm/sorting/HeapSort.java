package com.minos.algorithm.sorting;

import com.minos.algorithm.objectfortest.ArrayGenerator;
import com.minos.algorithm.objectfortest.SortingHelper;
import com.minos.datastructure.heap.maxheap.MaxHeap;

import java.util.Arrays;

/**
 * 堆排序  时间复杂度 nlogn
 *
 * @author: minos
 * @date: 2020/11/24 20:38
 */
public class HeapSort {

    private HeapSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        // 把数组中的元素放入到堆中，最大堆的性质会自然堆元素进行排序
        for (E e : data) {
            maxHeap.add(e);
        }

        // 升序排序
        for (int i = data.length - 1; i >= 0; i--) {
            // 把最大堆中的根节点元素（即最大值）取出，依次从数组末尾开始放入，实现排序
            data[i] = maxHeap.extractMax();
        }
    }


    /**
     * 原地排序
     * @param data
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort2(E[] data) {

        if (data.length <= 1) {
            return;
        }

        for (int i = (data.length - 2) / 2; i >= 0; i--) {
            siftDown(data, i, data.length);
        }

        // 把堆中的数组最大值放到数组末尾
        for (int i = data.length - 1; i >= 0; i--) {
            swap(data, 0, i);
            // 维护交换后的最大堆 （排除交换后的最大元素）
            siftDown(data, 0, i);
        }

    }

    /**
     * 对data[0, n)所形成的最大堆中，索引K的元素，执行siftDown
     *
     * @param data
     * @param k    siftDown的元素的索引
     * @param n    最大堆的边界
     * @param <E>
     */
    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {

        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n &&
                    data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(data, k, j);
            k = j;
        }
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int n = 1000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);
        Integer[] arr5 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("QuickSort2ways", arr2);
        SortingHelper.sortTest("QuickSort3ways", arr3);
        SortingHelper.sortTest("HeapSort", arr4);
        SortingHelper.sortTest("HeapSort2", arr5);


    }

}
