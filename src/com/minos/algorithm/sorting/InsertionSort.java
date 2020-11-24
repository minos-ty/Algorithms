package com.minos.algorithm.sorting;

import com.minos.algorithm.objectfortest.ArrayGenerator;
import com.minos.algorithm.objectfortest.SortingHelper;

import java.util.Arrays;

/**
 * 时间复杂度：O(n^2)
 * @Author: minos
 * @Date: 2020/11/7 11:24
 */
public class InsertionSort {

    private InsertionSort() {
    }

//    public static <E extends Comparable<E>> void sort(E[] arr) {
//
//        for (int i = 0; i < arr.length; i++) {

//             //将 arr[i] 插入到合适的位置
//            for (int j = i; j - 1 >= 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    swap(arr, j, j - 1);
//                }else {
//                    // 关键！！！ 如果arr[i] > arr[i - 1] 则跳出循环不再比较
//                    break;
//                }
//            }

            //简化写法
//            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
//                swap(arr, j, j - 1);
//            }
//
//
//        }
//    }
//
//    private static <E> void swap(E[] arr, int j, int i) {
//        E temp = arr[j];
//        arr[j] = arr[i];
//        arr[i] = temp;
//    }

    /**
     * 插入排序最终版
     * 常数级别优化  优化后实际测试的结果比上一个速度快
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {

            E temp = arr[i];
            int j;
            //注意这里是拿当前获得的较小值和他前面的元素依次比较
            //较小值往前插
            for (j = i; j - 1 >= 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                //如果arr[j] < arr[j - 1], 则把 arr[j - 1] 向右移
                arr[j] = arr[j - 1];
            }
            // 当arr[j] > arr[j-1]时, 此时的较小值找到插入index j
            arr[j] = temp;
        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

        for (int i = l; i <= r; i++) {

            E temp = arr[i];
            int j;
            //注意这里是拿当前获得的较小值和他前面的元素依次比较
            //较小值往前插
            for (j = i; j - 1 >= l && temp.compareTo(arr[j - 1]) < 0; j--) {
                //如果arr[j] < arr[j - 1], 则把 arr[j - 1] 向右移
                arr[j] = arr[j - 1];
            }
            // 当arr[j] > arr[j-1]时, 此时的较小值找到插入index j
            arr[j] = temp;
        }
    }



    public static void main(String[] args) {

        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            System.out.println("Random Array : ");

            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);

            SortingHelper.sortTest("InsertionSort", arr);
            SortingHelper.sortTest("SelectionSort", arr2);

            System.out.println();

            System.out.println("Ordered Array : ");

            arr = ArrayGenerator.generateOrderedArray(n);
            arr2 = Arrays.copyOf(arr, arr.length);

            SortingHelper.sortTest( "InsertionSort",arr);
            SortingHelper.sortTest("SelectionSort", arr2);

            System.out.println();
        }


    }
}
