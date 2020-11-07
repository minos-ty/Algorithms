package com.minos.algorithm.course.search;

import com.minos.algorithm.course.objectForTest.ArrayGenerator;

/**
 * @Author: minos
 * @Date: 2020/11/6 00:00
 */
public class LinearSearch {

    /**
     * 私有化构造方法，禁止用户实例化该类
     */
    private LinearSearch() {
    }

    /**
     * 查找元素target是存在于数组data中，若存在返回其索引，否则返回-1
     *
     * @param data
     * @param target
     * @param <E> 写在返回值前面，泛型方法的声明方式，表示该方法用要用到<E>类型的数据
     * @return
     */
    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            //当涉及引用数据类型（类对象）判等时，使用equals()方法
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        //int n = 1000000;

        int[] dataSize = {1000000, 10000000};

        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                LinearSearch.search(data, n);
            }
            long endTime = System.nanoTime();
            //结果纳秒转换成秒
            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("n=" + n + ", 100 runs: " + time  + "s" );
            
        }



    }
}
