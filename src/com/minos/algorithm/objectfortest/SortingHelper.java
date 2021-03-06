package com.minos.algorithm.objectfortest;

import com.minos.algorithm.sorting.*;
import com.minos.algorithm.mydemo.sorting.InsertionSortHM;
import com.minos.algorithm.mydemo.sorting.SelectionSortHM;
import com.minos.algorithm.mydemo.sorting.InsertSort;

/**
 * 验证排序算法是否正确
 *
 * @Author: minos
 * @Date: 2020/11/6 23:27
 */
public class SortingHelper {

    private SortingHelper() {
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {

        long startTime = System.nanoTime();
        if (sortName.equals("SelectionSort")) {
            SelectionSort.sort(arr);
        } else if (sortName.equals("SelectionSortHM")) {
            SelectionSortHM.sort(arr);
        } else if (sortName.equals("InsertSort")) {
            InsertSort.sort(arr);
        } else if (sortName.equals("InsertionSort")) {
            InsertionSort.sort(arr);
        } else if (sortName.equals("InsertionSortHM")) {
            InsertionSortHM.sort(arr);
        } else if (sortName.equals("MergeSort")) {
            MergeSort.sort(arr);
        } else if (sortName.equals("MergeSort2")) {
            MergeSort.sort2(arr);
        } else if (sortName.equals("MergeSort3")) {
            MergeSort.sort3(arr);
        } else if (sortName.equals("QuickSort")) {
            QuickSort.sort(arr);
        } else if (sortName.equals("QuickSort2ways")) {
            QuickSort.sort2ways(arr);
        } else if (sortName.equals("QuickSort3ways")) {
            QuickSort.sort3ways(arr);
        } else if (sortName.equals("HeapSort")) {
            HeapSort.sort(arr);
        } else if (sortName.equals("HeapSort2")) {
            HeapSort.sort2(arr);
        } else if (sortName.equals("BubbleSort")) {
            BubbleSort.sort(arr);
        }else if (sortName.equals("BubbleSort2")) {
            BubbleSort.sort2(arr);
        }else if (sortName.equals("BubbleSort3")){
            BubbleSort.sort3(arr);
        }else if (sortName.equals("ShellSort")) {
            ShellSort.sort(arr);
        }

        long endTime = System.nanoTime();

        //1,000,000,000 纳秒换算成秒
        double time = (endTime - startTime) / 1000000000.0;

        //验证排序算法是否正确
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortName + " failed.");
        }
        System.out.println(String.format("%s, n = %d : %fs", sortName, arr.length, time));
    }
}












