package com.minos.datastructure.recursion;

/**
 * @Author: minos
 * @Date: 2020/10/20 13:20
 */
public class RecursionArray {

    public static int recursionSum(int[] arr, int l ){

        if (l == arr.length){
            return 0;
        }
        return arr[l] + recursionSum(arr, l + 1);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        System.out.println(recursionSum(arr, 0));
    }
}
