package com.minos.algorithm.mydemo.sorting;

import com.minos.algorithm.course.objectfortest.ArrayGenerator;
import com.minos.algorithm.course.objectfortest.SortingHelper;

/**
 * @Author: minos
 * @Date: 2020/11/7 09:47
 */
public class SelectionSortHM {

    private SelectionSortHM() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {

        // arr[0...i)是无序的，arr[i...n)是有序的 ==》 循环不变量
        for (int i = arr.length - 1; i >= 0; i--) {

            int maxIndex = i;
            for (int j = i; j >= 0; j --) {
                if (arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }

            swap(arr, i, maxIndex);

        }

    }

    private static <E> void swap(E[] arr, int i, int maxIndex) {
        E temp = arr[i];
        arr[i] = arr[maxIndex];
        arr[maxIndex] = temp;
    }


    public static void main(String[] args) {

       int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSortHM", arr);
        }

    }

}










