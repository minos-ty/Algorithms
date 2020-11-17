package com.minos.algorithm.mydemo.search;

import java.util.List;

/**
 * @Author: minos
 * @Date: 2020/11/5 23:03
 */
public class MyLinearSearch{

    /**
     * 私有化构造函数，防止用户创建对象
     */
    private MyLinearSearch(){}

    /**
     * 查找数组中元素，若存在则返回其下标，否则返回-1
     * @return
     */
    public static int search(List<Integer> list, int targetElement) {

        for (int i = 0; i < list.size(); i++) {
            //如果数组中存的是应用数据类型该怎么改进？
            if (list.get(i) == targetElement) {
                return i;
            }
        }
        return  -1;
    }
}
