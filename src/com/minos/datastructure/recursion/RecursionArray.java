package com.minos.datastructure.recursion;

import java.util.LinkedList;
import java.util.List;

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

    public static List<Integer> removeElem(List<Integer> list, int i){

        if (list == null){
            return null;
        }

        return null;
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        System.out.println(recursionSum(arr, 0));

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        System.out.println(list);
    }
}















