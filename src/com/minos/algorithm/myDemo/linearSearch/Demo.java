package com.minos.algorithm.myDemo.linearSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: minos
 * @Date: 2020/11/5 23:18
 */
public class Demo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,6, 2, 3, 8, 10, 20);

        System.out.println(MyLinearSearch.search(list, 10));
    }
}
