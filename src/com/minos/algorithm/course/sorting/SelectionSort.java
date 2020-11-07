package com.minos.algorithm.course.sorting;

import com.minos.algorithm.course.objectForTest.ArrayGenerator;
import com.minos.algorithm.course.objectForTest.SortingHelper;

/**
 * @Author: minos
 * @Date: 2020/11/6 21:36
 */
public class SelectionSort {

    private SelectionSort() {}

    /**
     * 泛型数据设计到比较大小需要让给泛型加上规则，让传入的泛型实现Comparable接口
     * 然后用compareTo()方法比较 方法调用者小于被传入方法者时，返回负数 相等返回0 大于返回正数
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {

        // arr[0...i)是有序的，arr[i...n)是无序的 ==》 循环不变量
        for (int i = 0; i < arr.length; i++) {

            // 选择 arr[i...n) 中的最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) <0 ){
                    minIndex = j;
                }
            }

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
