package com.minos.algorithm.mydemo.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: minos
 * @Date: 2020/11/18 09:52
 */
public class SelectionSort {

    private SelectionSort() {}

    public static Integer[] sort(Integer[] arr) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
        Integer[] newArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = findSmallest(list);
        }
        return newArr;
    }

    private static int findSmallest(List<Integer> list) {

        int smallest = list.get(0);
        int smallestIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < smallest){
                smallest = list.get(i);
                smallestIndex = i;
            }
        }
        list.remove(smallestIndex);
        return smallest;
    }

    public static void main(String[] args) {
        Integer[] arr = {6, 7, 1, 10, 4, 2};
        Integer[] sorted = SelectionSort.sort(arr);
        for (Integer integer : sorted) {
            System.out.print(integer + " ");
        }
    }
}
