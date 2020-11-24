package com.minos.algorithm.search;

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

    /**
     * 找大于target的最小值
     */
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        // 如果给的target比数组中最大的一个值还要大，就用data.length表示（超出数组的边界）
        int l = 0, r = data.length;

        // data[l, r] 循环不变量
        while (l < r) {

            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                // 此时的mid仍然可能是问题的解，data[mid] > target但没确定是大于target的最小值
                r = mid;
            }
        }
        return l;
    }

    /**
     * 大于target, 返回最小值索引
     * 等于target, 返回最大索引
     */
    public static <E extends Comparable<E>> int ceil(E[] data, E target) {
        int u = upper(data, target);
        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
            return u - 1;
        }
        return u;
    }

    /**
     * 小于target的最大值索引
     */
    public static <E extends Comparable<E>> int lower(E[] data, E target) {

        int l = -1, r = data.length - 1;

        // data[l, r] 循环不变量
        while (l < r) {

            //  (r - l + 1) 解决l 和 r 相邻时循环进入死循环的问题
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {

        Integer[] arr = {1, 1, 3, 3, 5, 5,};

        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.lower(arr, i) + " ");
        }
        System.out.println();
    }
}
