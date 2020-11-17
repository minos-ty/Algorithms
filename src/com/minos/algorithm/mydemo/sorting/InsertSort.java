package com.minos.algorithm.mydemo.sorting;

import com.minos.algorithm.course.objectfortest.ArrayGenerator;
import com.minos.algorithm.course.objectfortest.SortingHelper;

/**
 * @Author: minos
 * @Date: 2020/11/7 10:54
 */
public class InsertSort {

    private InsertSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            //这里的比较方法虽然实现了排序 但是和算法分析的步骤理论上没统一
            //应该是让 j 和 j-1 来比较；把 j >= 0 改为 j-1 >= 0 这就解决了索引越界的问题
            for (int j = i; j >= 0; j-- ) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    E temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("InsertSort", arr);
        }
    }
}
