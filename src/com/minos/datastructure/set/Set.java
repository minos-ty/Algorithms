package com.minos.datastructure.set;

/**
 * @Author: minos
 * @Date: 2020/11/23 19:24
 */
public interface Set<E> {

    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
