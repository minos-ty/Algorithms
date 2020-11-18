package com.minos.algorithm.mydemo.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: minos
 * @Date: 2020/11/17 16:29
 */
public class BinarySearch {

    private BinarySearch() {

    }

    public static int search(List<Integer> list, int item) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int ret = list.get(mid);
            if (ret > item) {
                high = mid - 1;
            }else if (ret < item) {
                low = mid  +1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 3, 5, 7, 9);
        int ret = BinarySearch.search(list, 7);
        System.out.println(ret);
    }
}
