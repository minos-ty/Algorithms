package com.minos.algorithm.sorting;

import com.minos.algorithm.objectfortest.ArrayGenerator;
import com.minos.algorithm.objectfortest.SortingHelper;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author: minos
 * @date: 2020/11/26 20:56
 */
public class ShellSort {

    private ShellSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {

        int h = data.length / 2;
        while (h >= 1) {

            for (int start = 0; start < h; start++) {

                // 对data[start, start + h, start + 2h, start + 3h ... ], 进行插入排序
                for (int i = start + h; i < data.length; i += h) {

                    E t = data[i];
                    int j;
                    for (j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h) {
                        data[j] = data[j - h];
                    }
                    data[j] = t;
                }
            }

            h /= 2;
        }
    }

    public static void main(String[] args) {

        int n = 100000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("ShellSort", arr);
        // 时间复杂度 nlogn 在数据改为百万级别时，希尔排序法要慢一点
        SortingHelper.sortTest("MergeSort", arr3);
        // 时间复杂度 n^2
        SortingHelper.sortTest("InsertionSort", arr2);

    }
}
