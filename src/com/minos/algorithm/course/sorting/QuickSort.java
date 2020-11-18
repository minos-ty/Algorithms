package com.minos.algorithm.course.sorting;

import com.minos.algorithm.course.objectfortest.ArrayGenerator;
import com.minos.algorithm.course.objectfortest.SortingHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: minos
 * @Date: 2020/11/18 23:08
 */
public class QuickSort {

    static Random random =  new Random();

    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {

        //生成[l, r] 之间的随机索引
        int p = l + random.nextInt(r - l + 1);
        // 解决数组有序时递归深度为n导致算法复杂度为n^2的问题
        swap(arr, l, p);

        // arr[l+1...j] < v; arr[j+1...i] >= v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            // l 位置的元素就是选择的哪个partition数
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        // 把partition数放到两组数的中间
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int n = 1000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("QuickSort", arr2);

        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("QuickSort", arr2);
    }


}
