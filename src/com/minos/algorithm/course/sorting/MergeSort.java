package com.minos.algorithm.course.sorting;

import com.minos.algorithm.course.objectfortest.ArrayGenerator;
import com.minos.algorithm.course.objectfortest.SortingHelper;

import java.util.Arrays;

/**
 * @Author: minos
 * @Date: 2020/11/17 19:14
 */
public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 递归实现
     * 需要传入左右边界，而传入左右边界应该对用户透明，用户只要传入数组排序就行
     *
     * @param arr
     * @param l
     * @param r
     * @param <E>
     */
    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

        // 递归终止条件
        if (l >= r) {
            return;
        }

        // 如果数据规模上亿级别的时候， 直接l + r可能会造成整形表示的溢出
        // int mid = (l + r) / 2;
        // 可能的整形溢出的解决方案 把加法变为减法解决了溢出问题，
        // 从数学的角度推理mid的值和上面的计算方法是一样的
        int mid = l + (r - l) / 2;

        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);

    }

    /**
     * 归并的过程
     * 合并两个有序的区间 arr[l, mid] arr[mid + 1, r]
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @param <E>
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {

        // 原数组copy到temp中， 此时如果继续用l来取temp中的元素， 存在一个偏移量l
        // 即第一个元素为 l - l, 第二个元素为 l + 1 - l, 如此类推
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;
        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                // i 越界的情况 由于原数copy到temp中，tem
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                // j 越界的情况
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {

        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        // MergeSort, n = 100000 : 0.136892s
        SortingHelper.sortTest("MergeSort", arr);
        // InsertionSort, n = 100000 : 18.145893s
        SortingHelper.sortTest("InsertionSort", arr2);
        // SelectionSort, n = 100000 : 24.946469s
        SortingHelper.sortTest("SelectionSort", arr3);

    }
}
