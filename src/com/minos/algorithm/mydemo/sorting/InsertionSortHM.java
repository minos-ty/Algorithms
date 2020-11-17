package com.minos.algorithm.mydemo.sorting;

import com.minos.algorithm.course.objectfortest.ArrayGenerator;
import com.minos.algorithm.course.objectfortest.SortingHelper;

/**
 * @Author: minos
 * @Date: 2020/11/7 14:30
 */
public class InsertionSortHM {

    private InsertionSortHM() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {

            E temp = arr[i];
            int j;
            // 拿当前的arr[i] 和 他的 后一个arr[i + 1] 比较
            // 如果当前值比后一个值大，继续往后比较
            // 把较大的往后面插
            for (j = i; j + 1 < arr.length && temp.compareTo(arr[j + 1]) > 0; j++) {
                //把大的往右边放
                arr[j] = arr[j + 1];
            }
            arr[j] = temp;
        }

    }


    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("InsertionSortHM", arr);
        }
    }
}
