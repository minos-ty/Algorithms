package com.linearsearch;

public class LinearSearch {
    //类构造方法私有化，防止用户创建类
    private LinearSearch(){
    }

    /**
     * 线性查找，根据目标元素返回数组中对应的下标
     * @param data 数组
     * @param target 目标元素
     * @return 返回目标元素对应的下标,若数组中找不到目标元素则返回-1
     */
    public static int search(int[] data, int target){
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target){
                return i;
            }
        }
        return -1;
    }
}
