package com.minos.datastructure.stack;

/**
 * @Author: minos
 * @Date: 2020/9/15 21:05
 */
public interface Stack<E> {

    /**
     * 返回Stack大小
     * @return
     */
    int getSize();

    /**
     * 判断Stack是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入栈
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 获取栈顶元素
     * @return
     */
    E peak();
}
