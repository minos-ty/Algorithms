package com.minos.algorithm.myDemo.linearSearch;

import java.util.List;

/**
 * @Author: minos
 * @Date: 2020/11/5 23:03
 */
public class MyLinearSearch<T> {
    private T element;
    private List<T> list;

    public MyLinearSearch() {
    }

    public MyLinearSearch(T element, List<T> list) {
        this.element = element;
        this.list = list;
    }

    /**
     * 查找数组中元素，若存在则返回其下标，否则返回-1
     * @return
     */
    public int search() {

        for (int i = 0; i < list.size(); i++) {
            //如果数组中存的是应用数据类型该怎么改进？
            if (list.get(i) == element) {
                return i;
            }
        }
        return  -1;
    }
}
