package com.minos.algorithm.recursion;

/**
 * 递归 设计递归的时候不要纠结递归每一步怎么执行的
 * 从宏观的语义上来分析出 1.递归终止条件 2.如何把大问题分解成小问题
 *
 * 递归的调用是很消耗系统栈空间的
 *
 * @Author: minos
 * @Date: 2020/10/20 13:20
 */
public class RecursionArray {

    public static int recursionSum(int[] arr, int l ){

        // 递归终止条件
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















