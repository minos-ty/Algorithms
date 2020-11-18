package com.minos.algorithm.mydemo.recursion;

/**
 * @Author: minos
 * @Date: 2020/11/18 13:53
 */
public class Sum {

    private Sum() {}

    public static int sum(int[] arr) {
       return sum(arr, 0);
    }

    private static int sum(int[] arr, int l) {

        if (l == arr.length) {
            return 0;
        }

        return arr[l] + sum(arr, l + 1);
    }
}
