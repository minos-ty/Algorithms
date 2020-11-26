package com.minos.algorithm.sorting;

import com.minos.algorithm.objectfortest.ArrayGenerator;
import com.minos.algorithm.objectfortest.SortingHelper;

import java.util.Arrays;

/**
 * 时间复杂度O(n^2)
 *
 * @author: minos
 * @date: 2020/11/26 18:47
 */
public class BubbleSort {

    private BubbleSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {

        for (int i = 0; i < data.length; i++) {

            // arr[n - i, n)已排好序 循环不变量
            // 通过冒泡在arr[n - i - 1]位置上放上合适的元素
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                }
            }
        }
    }

    /**
     * 优化1
     *
     * @param data
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort2(E[] data) {

        for (int i = 0; i < data.length; i++) {
            // 记录停止交换的位置
            boolean isSwapped = false;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }

    }

    /**
     * 优化2 最优版本
     *
     * @param data
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort3(E[] data) {

        for (int i = 0; i < data.length; ) {
            //记录是否发生交换
            int lastSwappedIndex = 0;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    lastSwappedIndex = j + 1;
                }
            }

            //当不再发生交换时， lastSwappedIndex = 0，此时 i = data.length 循环终止
            i = data.length - lastSwappedIndex;
        }
    }


    private static <E> void swap(E[] data, int j, int i) {
        E t = data[j];
        data[j] = data[i];
        data[i] = data[j];
    }

    public static void main(String[] args) {
        int n = 100000;

        System.out.println("Random Array:");
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("BubbleSort", arr);
        SortingHelper.sortTest("BubbleSort2", arr2);
        SortingHelper.sortTest("BubbleSort3", arr3);
        System.out.println();

        System.out.println("Ordered Array:");
        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("BubbleSort", arr);
        SortingHelper.sortTest("BubbleSort2", arr2);
        SortingHelper.sortTest("BubbleSort3", arr3);

    }
}
