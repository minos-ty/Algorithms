package com.minos.algorithm.objectfortest;

import java.util.Random;

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

    /**
     * 生成一个长度为n的随机数组，每一个数组的范围是 [0, bound)
     * @param n 需生成数组的长度
     * @param bound 随机数的上界（取不到）
     * @return 随机数组
     */
    public static Integer[] generateRandomArray(int n, int bound) {

        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
}

















