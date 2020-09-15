package com.minos.datastructure.stack;

/**
 * @Author: minos
 * @Date: 2020/9/15 21:05
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peak();
}
