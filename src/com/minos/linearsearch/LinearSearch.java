package com.minos.linearsearch;

public class LinearSearch{
    //类的构造方法私有化，防止用户创建类对象，使其只能通过类名直接调用方法
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

    /**
     * 改进：使用泛型让算法支持查找所有类型数组
     * 注意️：Java中泛型只能接收类对象
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E> int search(E[] data, E target){
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)){//引用数据类型判等用equals方法
                return i;
            }
        }
        return -1;
    }


}
