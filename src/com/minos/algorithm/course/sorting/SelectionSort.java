package com.minos.algorithm.course.sorting;

import com.minos.algorithm.course.objectfortest.ArrayGenerator;
import com.minos.algorithm.course.objectfortest.SortingHelper;

/**
 *选择排序（Selection sort）是一种简单直观的排序算法。
 *它的工作原理如下。首先在未排序序列中找到最小（大）元素，
 *存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
 *然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * @Author: minos
 * @Date: 2020/11/6 21:36
 */
public class SelectionSort {

    private SelectionSort() {}

    /**
     * 泛型数据涉及到比较大小需要让给泛型加上规则，让传入的泛型实现Comparable接口
     * 然后用compareTo()方法比较 方法调用者小于被传入方法者时，返回负数 相等返回0 大于返回正数
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {

        // arr[0...i)是有序的，arr[i...n)是无序的 ==》 循环不变量
        for (int i = 0; i < arr.length; i++) {

            // 开始默认0索引之前的数时排好序的（理论上来理解，这样思考便于逻辑的统一）
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                // 从arr[i...n)中找出最小的一个数
                if (arr[j].compareTo(arr[minIndex]) <0 ){
                    minIndex = j;
                }
            }

            // 把最小的一个数放到已排序的末尾
            swap(arr, i, minIndex);
        }

    }

    private static <E> void swap(E[] arr, int i, int minIndex) {
        E temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void main(String[] args) {

        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);

            // 性能测试
            SortingHelper.sortTest( "SelectionSort",arr);
        }


        /*
        //自定义类对象排序测试
        Student[] students = {new Student("minos", 18),
                              new Student("Fan", 16),
                              new Student("Ye", 13)};

        SelectionSort.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
         */

    }
}
