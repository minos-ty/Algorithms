package com.minos.algorithm.course.search;

/**
 * @Author: minos
 * @Date: 2020/11/21 16:42
 */
public class BinarySearch {

    private BinarySearch() {
    }

    /**
     * 递归实现
     */
    public static <E extends Comparable<E>> int searchR(E[] data, E target) {

        return searchR(data, 0, data.length - 1, target);
    }


    private static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {

        if (l > r) {
            return -1;
        }

        // 这种方式获取中间值可以避免整形溢出的问题
        int mid = l + (r - l) / 2;

        if (data[mid].compareTo(target) < 0) {
            // 说明要找的值在mid的右侧
            return searchR(data, mid + 1, r, target);
        } else if (data[mid].compareTo(target) > 0) {
            return searchR(data, l, mid - 1, target);
        } else {
            return mid;
        }

    }

    /**
     * 非递归实现
     */
    public static <E extends Comparable<E>> int search(E[] data, E target) {

        int l = 0, r = data.length - 1;
        // 循环不变量 target 在 data[l, r]
        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (data[mid].compareTo(target) == 0) {
                return mid;
            }

            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return -1;
    }
}
