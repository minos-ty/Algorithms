package com.minos.algorithm.course.search;

/**
 * 算法性能测试用例
 * @Author: minos
 * @Date: 2020/11/6 19:07
 */
public class ArrayGenerator {

    private ArrayGenerator() {}

    public static Integer[] generateOrderedArray(int n) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
}

















