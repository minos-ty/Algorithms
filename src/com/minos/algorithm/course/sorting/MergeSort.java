package com.minos.algorithm.course.sorting;

import com.minos.algorithm.course.objectfortest.ArrayGenerator;
import com.minos.algorithm.course.objectfortest.SortingHelper;

import java.util.Arrays;

/**
 * 时间复杂度： o(nlogn)
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
     * 优化
     */
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        sort2(arr, 0, arr.length - 1);
    }

    /**
     * 优化
     */
    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {

        // 如果数据规模较小，调用插入排序法来排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        sort2(arr, l, mid);
        sort2(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }

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

    /**
     * 优化 ， 对merge优化
     */
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort3(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void sort3(E[] arr, int l, int r, E[] temp) {

        // 如果数据规模较小，调用插入排序法来排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        sort3(arr, l, mid, temp);
        sort3(arr, mid + 1, r, temp);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge2(arr, l, mid, r, temp);
        }

    }

    private static <E extends Comparable<E>> void merge2(E[] arr, int l, int mid, int r, E[] temp) {

        // arr中从l开始的元素拷贝到temp中从l位置开始存 拷贝长度为 r - l + 1
        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {

                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }


    public static void main(String[] args) {

        int n = 5000000;

        // 优化前后的对比
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("MergeSort2", arr2);
        SortingHelper.sortTest("MergeSort3", arr3);


        // 不同排序优劣的对比  n = 100000;
//        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
//        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
//
//        // MergeSort, n = 100000 : 0.136892s
//        SortingHelper.sortTest("MergeSort", arr);
//        // InsertionSort, n = 100000 : 18.145893s
//        SortingHelper.sortTest("InsertionSort", arr2);
//        // SelectionSort, n = 100000 : 24.946469s
//        SortingHelper.sortTest("SelectionSort", arr3);

    }
}
