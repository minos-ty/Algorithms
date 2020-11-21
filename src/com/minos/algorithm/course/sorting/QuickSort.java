package com.minos.algorithm.course.sorting;

import com.minos.algorithm.course.objectfortest.ArrayGenerator;
import com.minos.algorithm.course.objectfortest.SortingHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序是一个随机算法，复杂的分析不应该去看最坏(o^2)情况，要看期望
 * 复杂度的期望：o(nlogn)
 *
 * @Author: minos
 * @Date: 2020/11/18 23:08
 */
public class QuickSort {

    static Random random = new Random();

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

    public static <E extends Comparable<E>> void sort2ways(E[] arr) {
        sort2ways(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort2ways(E[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int p = partition2(arr, l, r);
        sort2ways(arr, l, p - 1);
        sort2ways(arr, p + 1, r);
    }

    /**
     * 双路快速排序， 对上一个实现的优化
     *
     * @param arr
     * @param l 左端点
     * @param r 右端点
     * @param <E>
     * @return
     */
    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r) {

        //生成[l, r] 之间的随机索引
        int p = l + random.nextInt(r - l + 1);
        // 解决数组有序时递归深度为n导致算法复杂度为n^2的问题
        swap(arr, l, p);

        // arr[l+1...i-1 ] <= v; arr[j+1...r] >= v
        int i = l + 1, j = r;
        while (true) {

            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }

            while (i >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    public static <E extends Comparable<E>> void sort3ways(E[] arr) {
        sort3ways(arr, 0, arr.length - 1);
    }

    // 三路快速排序 当数据中可能含有大量重复元素的时候 该算法时间复杂度可能进化为n
    private static <E extends Comparable<E>> void sort3ways(E[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        //生成[l, r] 之间随机的索引
        int p = l + random.nextInt(r - l + 1);
        // 把随机选到的元素放到最左边
        swap(arr, l, p);

        // arr[l + 1, lt] < v, arr[lt + 1, i - 1] == v, arr[gt, r] > v 循环不变量
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt) {

            // 把小于arr[l]的值往arr[i]的左边放
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            }
            // 把大于arr[l]的值往arr[i]右边放
            else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);
            } else { // arr[i] == arr[l]
                // 相当于扩充区间 arr[lt + 1, i - 1]
                i++;
            }
        }

        // 将选定的元素挪到中间
        swap(arr, l, lt);

        // 此时循环不变量变为 arr[l, lt - 1] < v, arr[lt, gt - 1] == v, arr[gt, r] > v
        sort3ways(arr, l, lt - 1);
        sort3ways(arr, gt, r);

    }


    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int n = 100000;

        System.out.println("Random Array:");
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2ways", arr2);
        SortingHelper.sortTest("QuickSort3ways", arr3);
        System.out.println();

        System.out.println("Ordered Array:");
        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2ways", arr2);
        SortingHelper.sortTest("QuickSort3ways", arr3);
        System.out.println();


        System.out.println("Same value Array:");
        arr = ArrayGenerator.generateRandomArray(n, 1);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2ways", arr2);
        SortingHelper.sortTest("QuickSort3ways", arr3);

    }


}
